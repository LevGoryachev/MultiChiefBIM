package ru.goryachev.multichief.construction.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.construction.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.construction.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.entity.Eir;
import ru.goryachev.multichief.construction.repository.EirRepository;
import ru.goryachev.multichief.construction.service.StandardService;
import ru.goryachev.multichief.construction.service.converter.EirConverter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StandardEirService works with types: EirCommonDto, Eir
 * @author Lev Goryachev
 * @version 1.1
 */

@Service
@PropertySource("classpath:service_layer.properties")
public class StandardEirService implements StandardService {

    private EirRepository eirRepository;
    private EirConverter eirConverter;

    @Value("${model.entity.alias.eir}")
    private String eirEntityAlias;

    @Autowired
    public StandardEirService(EirRepository eirRepository, EirConverter eirConverter) {
        this.eirRepository = eirRepository;
        this.eirConverter = eirConverter;
    }

    @Override
    public List<CommonDto> getAll () {
        List<Eir> allMaterials = eirRepository.findAll();
        if (allMaterials.isEmpty()) {
            throw new MultiChiefEmptyListException(eirEntityAlias);
        }
        return allMaterials.stream().map(eirConverter::entityToDto).collect(Collectors.toList());
    }

    public CommonDto getById (Long id) {
        Eir eir = eirRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(eirEntityAlias, id));
        return eirConverter.entityToDto(eir);
    }

    @Override
    public Map<String, Object> create (CommonDto eirCommonDto) {
        Eir eir = (Eir) eirConverter.dtoToEntity(eirCommonDto);

        Eir savedEir = eirRepository.save(eir);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", eirEntityAlias + " " + "was saved in DB");
        responseBody.put("id", savedEir.getId());
        responseBody.put("code-number", savedEir.getEirCodeNumber());
        return responseBody;
    }

    @Override
    public Map<String, Object> update (CommonDto modifiedEir) {
        Eir eir = (Eir) eirConverter.dtoToEntity(modifiedEir);

        Eir savedEir = eirRepository.save(eir);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", eirEntityAlias + " " + "was updated");
        responseBody.put("id", savedEir.getId());
        responseBody.put("code-number", savedEir.getEirCodeNumber());
        return responseBody;
    }

    @Override
    public Map<String, Object> delete (Long id) {
        eirRepository.deleteById(id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", eirEntityAlias + " " + "with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
