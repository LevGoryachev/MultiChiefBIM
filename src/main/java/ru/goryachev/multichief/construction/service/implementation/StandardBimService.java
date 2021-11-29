package ru.goryachev.multichief.construction.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.construction.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.construction.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.entity.Bim;
import ru.goryachev.multichief.construction.repository.BimRepository;
import ru.goryachev.multichief.construction.service.StandardService;
import ru.goryachev.multichief.construction.service.converter.BimConverter;


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
public class StandardBimService implements StandardService {

    private BimRepository bimRepository;
    private BimConverter bimConverter;

    @Value("${model.entity.alias.bim}")
    private String bimEntityAlias;

    @Autowired
    public StandardBimService(BimRepository bimRepository, BimConverter bimConverter) {
        this.bimRepository = bimRepository;
        this.bimConverter = bimConverter;
    }

    @Override
    public List<CommonDto> getAll () {
        List<Bim> allMaterials = bimRepository.findAll();
        if (allMaterials.isEmpty()) {
            throw new MultiChiefEmptyListException(bimEntityAlias);
        }
        return allMaterials.stream().map(bimConverter::entityToDto).collect(Collectors.toList());
    }

    public CommonDto getById (Long id) {
        Bim bim = bimRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(bimEntityAlias, id));
        return bimConverter.entityToDto(bim);
    }

    @Override
    public Map<String, Object> create (CommonDto bimCommonDto) {
        Bim bim = (Bim) bimConverter.dtoToEntity(bimCommonDto);

        Bim savedBim = bimRepository.save(bim);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", bimEntityAlias + " " + "was saved in DB");
        responseBody.put("id", savedBim.getId());
        responseBody.put("name", savedBim.getProjectName());
        return responseBody;
    }

    @Override
    public Map<String, Object> update (CommonDto modifiedBim) {
        Bim bim = (Bim) bimConverter.dtoToEntity(modifiedBim);

        Bim savedBim = bimRepository.save(bim);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", bimEntityAlias + " " + "was updated");
        responseBody.put("id", savedBim.getId());
        responseBody.put("name", savedBim.getProjectName());
        return responseBody;
    }

    @Override
    public Map<String, Object> delete (Long id) {
        bimRepository.deleteById(id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", bimEntityAlias + " " + "with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
