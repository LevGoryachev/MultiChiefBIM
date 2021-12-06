package ru.goryachev.multichief.construction.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.EstimateCommonDto;
import ru.goryachev.multichief.construction.service.implementation.StandardEstimateService;

import java.util.List;

/**
 * MultiChiefConstruction API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/estimates")
public class EstimateController {

    private StandardEstimateService standardEstimateService;

    @Autowired
    public EstimateController(StandardEstimateService standardEstimateService) {
        this.standardEstimateService = standardEstimateService;
    }

    @GetMapping
    public ResponseEntity<List<CommonDto>> getAllEstimates () {
        return new ResponseEntity<>(standardEstimateService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CommonDto> getById (@PathVariable Long id) {
            return new ResponseEntity<>(standardEstimateService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody EstimateCommonDto estimateCommonDto) {
        return new ResponseEntity<>(standardEstimateService.create(estimateCommonDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody EstimateCommonDto modifiedEstimate) {
        return new ResponseEntity<>(standardEstimateService.update(modifiedEstimate), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(standardEstimateService.delete(id), HttpStatus.OK);
    }
}
