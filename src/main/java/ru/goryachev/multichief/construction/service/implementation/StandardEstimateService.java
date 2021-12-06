package ru.goryachev.multichief.construction.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.construction.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.construction.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.entity.Estimate;
import ru.goryachev.multichief.construction.repository.EstimateRepository;
import ru.goryachev.multichief.construction.service.StandardService;
import ru.goryachev.multichief.construction.service.converter.EstimateConverter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StandardEstimateService works with types: EstimateCommonDto, Estimate
 * @author Lev Goryachev
 * @version 1.1
 */

@Service
@PropertySource("classpath:service_layer.properties")
public class StandardEstimateService implements StandardService {

    @Value("${model.entity.alias.estimate}")
    private String estimateEntityAlias;

    private EstimateRepository estimateRepository;
    private EstimateConverter estimateConverter;

    @Autowired
    public StandardEstimateService(EstimateRepository estimateRepository, EstimateConverter estimateConverter) {
        this.estimateRepository = estimateRepository;
        this.estimateConverter = estimateConverter;
    }

    @Override
    public List<CommonDto> getAll () {
        List<Estimate> allMaterials = estimateRepository.findAll();
        if (allMaterials.isEmpty()) {
            throw new MultiChiefEmptyListException(estimateEntityAlias);
        }
        return allMaterials.stream().map(estimateConverter::entityToDto).collect(Collectors.toList());
    }

    public CommonDto getById (Long id) {
        Estimate estimate = estimateRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(estimateEntityAlias, id));
        return estimateConverter.entityToDto(estimate);
    }

    @Override
    public Map<String, Object> create (CommonDto estimateCommonDto) {
        Estimate estimate = (Estimate) estimateConverter.dtoToEntity(estimateCommonDto);

        Estimate savedEstimate = estimateRepository.save(estimate);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", estimateEntityAlias + " " + "was saved in DB");
        responseBody.put("id", savedEstimate.getId());
        responseBody.put("code-number", savedEstimate.getEstimateCodeNumber());
        return responseBody;
    }

    @Override
    public Map<String, Object> update (CommonDto modifiedEstimate) {
        Estimate estimate = (Estimate) estimateConverter.dtoToEntity(modifiedEstimate);

        Estimate savedEstimate = estimateRepository.save(estimate);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", estimateEntityAlias + " " + "was updated");
        responseBody.put("id", savedEstimate.getId());
        responseBody.put("code-number", savedEstimate.getEstimateCodeNumber());
        return responseBody;
    }

    @Override
    public Map<String, Object> delete (Long id) {
        estimateRepository.deleteById(id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", estimateEntityAlias + " " + "with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
