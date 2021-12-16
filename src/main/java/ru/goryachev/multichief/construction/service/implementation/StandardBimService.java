package ru.goryachev.multichief.construction.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.construction.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.construction.exception.MultiChiefObjectNotFoundException;
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
        Bim bim  = specialBimConverter.dtoToEntity(bimRequestDto);
        Map<String,Object> responseBody = new LinkedHashMap<>();

        if (!projectTypeRepository.existsById(bimRequestDto.getProjectTypeId())){
            bim.setProjectTypeId(null);
            responseBody.put("typenotfound", projectTypeEntityAlias + " " + "with id" + " " + bimRequestDto.getProjectTypeId() + " " + "was not found, and was set null");
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

    public Map<String, Object> delete (Long id) {
        bimRepository.deleteById(id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", bimEntityAlias + " " + "with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
