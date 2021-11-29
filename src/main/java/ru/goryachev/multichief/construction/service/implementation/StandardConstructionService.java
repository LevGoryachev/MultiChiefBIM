package ru.goryachev.multichief.construction.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.construction.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.construction.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.ConstructionCommonDto;
import ru.goryachev.multichief.construction.model.entity.Construction;
import ru.goryachev.multichief.construction.repository.ConstructionRepository;
import ru.goryachev.multichief.construction.service.StandardService;
import ru.goryachev.multichief.construction.service.converter.ConstructionConverter;

import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StandardConstructionService works with types: ConstructionCommonDto, Construction
 * @author Lev Goryachev
 * @version 1.1
 */

@Service
@PropertySource("classpath:service_layer.properties")
public class StandardConstructionService implements StandardService {

    private ConstructionRepository constructionRepository;
    private ConstructionConverter constructionConverter;

    @Value("${model.entity.alias.construction}")
    private String constructionEntityAlias;

    @Autowired
    public StandardConstructionService(ConstructionRepository constructionRepository, ConstructionConverter constructionConverter) {
        this.constructionRepository = constructionRepository;
        this.constructionConverter = constructionConverter;
    }

    @Override
    public List<CommonDto> getAll () {
        List<Construction> allMaterials = constructionRepository.findAll();
        if (allMaterials.isEmpty()) {
            throw new MultiChiefEmptyListException(constructionEntityAlias);
        }
        return allMaterials.stream().map(constructionConverter::entityToDto).collect(Collectors.toList());
    }

    //findById: items.stream().findAny().map((e) -> items).orElseThrow(NotFoundException::new);

    public CommonDto getById (Long id) {
        Construction construction = constructionRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(constructionEntityAlias, id));
        return constructionConverter.entityToDto(construction);
    }

    @Override
    public Map<String, Object> create (CommonDto constructionCommonDto) {
        Construction construction = (Construction) constructionConverter.dtoToEntity(constructionCommonDto);

        Construction savedConstruction = constructionRepository.save(construction);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", constructionEntityAlias + " " + "was saved in DB");
        responseBody.put("id", savedConstruction.getId());
        responseBody.put("name", savedConstruction.getObjectName());
        return responseBody;
    }

    @Override
    public Map<String, Object> update (CommonDto modifiedConstruction) {
        Construction construction = (Construction) constructionConverter.dtoToEntity(modifiedConstruction);

        Construction savedConstruction = constructionRepository.save(construction);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", constructionEntityAlias + " " + "was updated");
        responseBody.put("id", savedConstruction.getId());
        responseBody.put("name", savedConstruction.getObjectName());
        return responseBody;
    }

    @Override
    public Map<String, Object> delete (Long id) {
        constructionRepository.deleteById(id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", constructionEntityAlias + " " + "with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
