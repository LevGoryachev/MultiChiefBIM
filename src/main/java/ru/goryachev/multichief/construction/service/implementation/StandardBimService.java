package ru.goryachev.multichief.construction.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.construction.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.construction.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.request.BimRequestDto;
import ru.goryachev.multichief.construction.model.dto.response.BimPreformDTO;
import ru.goryachev.multichief.construction.model.entity.Bim;
import ru.goryachev.multichief.construction.repository.BimRepository;
import ru.goryachev.multichief.construction.repository.EirRepository;
import ru.goryachev.multichief.construction.repository.ProjectTypeRepository;
import ru.goryachev.multichief.construction.service.SpecialService;
import ru.goryachev.multichief.construction.service.converter.SpecialBimConverter;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StandardBimService works with types: BimCommonDto, Bim
 * @author Lev Goryachev
 * @version 1.1
 */

@Service
@PropertySource("classpath:service_layer.properties")
public class StandardBimService implements SpecialService {

    @Value("${model.entity.alias.bim}")
    private String bimEntityAlias;
    @Value("${model.entity.alias.projecttype}")
    private String projectTypeEntityAlias;
    @Value("${model.entity.alias.eir}")
    private String eirEntityAlias;

    private BimRepository bimRepository;
    private ProjectTypeRepository projectTypeRepository;
    private EirRepository eirRepository;
    private SpecialBimConverter specialBimConverter;

    @Autowired
    public StandardBimService(BimRepository bimRepository, ProjectTypeRepository projectTypeRepository, EirRepository eirRepository, SpecialBimConverter specialBimConverter) {
        this.bimRepository = bimRepository;
        this.projectTypeRepository = projectTypeRepository;
        this.eirRepository = eirRepository;
        this.specialBimConverter = specialBimConverter;
    }

   /* @Override
    public List<CommonDto> getAll () {
        List<Bim> allBims = bimRepository.findAll();
        if (allBims.isEmpty()) {
            throw new MultiChiefEmptyListException(bimEntityAlias);
        }
        return allBims.stream().map(bimConverter::entityToDto).collect(Collectors.toList());
    }

    public CommonDto getById (Long id) {
        Bim bim = bimRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(bimEntityAlias, id));
        return bimConverter.entityToDto(bim);
    }*/

    public List<BimPreformDTO> getAll () {
        List<Bim> allBims = bimRepository.findAll();
        if (allBims.isEmpty()) {
            throw new MultiChiefEmptyListException(bimEntityAlias);
        }
        return allBims.stream().map(specialBimConverter::entityToDto).collect(Collectors.toList());
    }

    public BimPreformDTO getById (Long id) {
        Bim bim = bimRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(bimEntityAlias, id));
        return specialBimConverter.entityToDto(bim);
    }

    public Map<String, Object> save (BimRequestDto bimRequestDto) {
        Bim bim = new Bim();
        Map<String,Object> responseBody = new LinkedHashMap<>();

        bim = specialBimConverter.dtoToEntity(bimRequestDto);

        if (!projectTypeRepository.existsById(bimRequestDto.getProjectTypeId())){
            bim.setProjectTypeId(null);
            responseBody.put("typenotfound", projectTypeEntityAlias + " " + "with id" + " " + bimRequestDto.getProjectTypeId() + " " + "was not found, and was set null");

            /*site.setEstimateId(constructionSiteRequestDto.getEstimateId());
            Site savedSite = siteRepository.save(site);
            responseBody.put("entity", savedSite);
            return responseBody;*/
        }

        if (!eirRepository.existsById(bimRequestDto.getEirId())){
            bim.setEirId(null);
            responseBody.put("eirnotfound", eirEntityAlias + " " + "with id" + " " + bimRequestDto.getEirId() + " " + "was not found, and was set null");
        }

        Bim savedBim = bimRepository.save(bim);
        responseBody.put("result", bimEntityAlias + " " + "was saved in DB");
        responseBody.put("id", savedBim.getId());
        responseBody.put("name", savedBim.getProjectName());
        return responseBody;
    }


    /*public Map<String, Object> update (BimRequestDto modifiedBim) {
        Bim bim = (Bim) specialBimConverter.dtoToEntity(modifiedBim);

        Bim savedBim = bimRepository.save(bim);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", bimEntityAlias + " " + "was updated");
        responseBody.put("id", savedBim.getId());
        responseBody.put("name", savedBim.getProjectName());
        return responseBody;
    }*/


    public Map<String, Object> delete (Long id) {
        bimRepository.deleteById(id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", bimEntityAlias + " " + "with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
