package ru.goryachev.multichief.construction.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.construction.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.construction.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.construction.model.dto.request.ConstructionSiteRequestDto;
import ru.goryachev.multichief.construction.model.entity.Site;
import ru.goryachev.multichief.construction.repository.BimRepository;
import ru.goryachev.multichief.construction.repository.ConstructionRepository;
import ru.goryachev.multichief.construction.repository.EstimateRepository;
import ru.goryachev.multichief.construction.repository.SiteRepository;
import ru.goryachev.multichief.construction.service.SpecialService;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * SpecialSiteService (Construction-Site domain service) gets ConstructionSiteRequestDto (bimId and estimateId (if they are exist))
 * and converts to Site (entity of Construction-Site) for saving in DB;
 * provides CRUD for Site.
 * @author Lev Goryachev
 * @version 1.1
 */

@Service
@PropertySource("classpath:service_layer.properties")
public class SpecialSiteService implements SpecialService {


    @Value("${model.entity.alias.site}")
    private String siteEntityAlias;
    @Value("${model.entity.alias.construction}")
    private String constructionEntityAlias;
    @Value("${model.entity.alias.bim}")
    private String bimEntityAlias;
    @Value("${model.entity.alias.estimate}")
    private String estimateEntityAlias;

    private SiteRepository siteRepository;
    private ConstructionRepository constructionRepository;
    private BimRepository bimRepository;
    private EstimateRepository estimateRepository;


    @Autowired
    public SpecialSiteService(SiteRepository siteRepository, ConstructionRepository constructionRepository, BimRepository bimRepository, EstimateRepository estimateRepository) {
        this.siteRepository = siteRepository;
        this.constructionRepository = constructionRepository;
        this.bimRepository = bimRepository;
        this.estimateRepository = estimateRepository;
    }

    public List<Site> getAll (){
        return siteRepository.findAll();
    }

    public List<Site> findAllByConstructionWithType (Long constructionId, String typeName) {
        List<Site> constructionSites;
        if (typeName == null){
            constructionSites = siteRepository.findByConstructionId(constructionId);
            if (constructionSites.isEmpty()){
                throw new MultiChiefEmptyListException(siteEntityAlias);
            }
            return constructionSites;
        }
        constructionSites = siteRepository.findAllByConstructionWithType(constructionId, typeName);
        if (constructionSites.isEmpty()){
            throw new MultiChiefEmptyListException(siteEntityAlias);
        }
        return constructionSites;
    }

    public Site getById (Long id) {
        Site site = siteRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(siteEntityAlias, id));
        return site;
    }

    @Transactional
    public Map<String, Object> save (Long constructionId, ConstructionSiteRequestDto constructionSiteRequestDto) {
        if (!constructionRepository.existsById(constructionId)){
            throw new MultiChiefObjectNotFoundException(constructionEntityAlias, constructionId);
        }
        Map<String,Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", siteEntityAlias +" " + "was saved in DB");

        Site site = new Site();
        site.setConstructionId(constructionId);

        if (!bimRepository.existsById(constructionSiteRequestDto.getBimId())){
            site.setBimId(null);
            responseBody.put("bimnotfound", bimEntityAlias + " " + "with id" + " " + constructionSiteRequestDto.getBimId() + " " + "was not found, and was set null");
            if (!estimateRepository.existsById(constructionSiteRequestDto.getEstimateId())){
                site.setEstimateId(null);
                Site savedSite = siteRepository.save(site);
                responseBody.put("estimatenotfound", estimateEntityAlias + " " + "with id" + " " + constructionSiteRequestDto.getEstimateId() + " " + "was not found, and was set null");
                responseBody.put("entity", savedSite);
                return responseBody;
            }
            site.setEstimateId(constructionSiteRequestDto.getEstimateId());
            Site savedSite = siteRepository.save(site);
            responseBody.put("entity", savedSite);
            return responseBody;
        }

        site.setBimId(constructionSiteRequestDto.getBimId());

        if (!estimateRepository.existsById(constructionSiteRequestDto.getEstimateId())){
            site.setEstimateId(null);
            Site savedSite = siteRepository.save(site);
            responseBody.put("estimatenotfound", estimateEntityAlias + " " + "with id" + " " + constructionSiteRequestDto.getEstimateId() + " " + "was not found, and was set null");
            responseBody.put("entity", savedSite);
            return responseBody;
        }

        site.setEstimateId(constructionSiteRequestDto.getEstimateId());

        Site savedSite = siteRepository.save(site);
        responseBody.put("entity", savedSite);
        return responseBody;
    }

    @Transactional
    public Map<String, Object> deleteByConstructionIdAndId (Long constructionId,Long id) {
       siteRepository.deleteByConstructionIdAndId(constructionId, id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", siteEntityAlias + " " + "with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
