package ru.goryachev.multichief.construction.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.BimCommonDto;
import ru.goryachev.multichief.construction.service.implementation.StandardBimService;

import java.util.List;

/**
 * MultiChiefConstruction API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/bims")
public class BimController {

    private StandardBimService standardBimService;

    @Autowired
    public BimController(StandardBimService standardBimService) {
        this.standardBimService = standardBimService;
    }

    @GetMapping
    public ResponseEntity<List<CommonDto>> getAllBims () {
        return new ResponseEntity<>(standardBimService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CommonDto> getById (@PathVariable Long id) {
            return new ResponseEntity<>(standardBimService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody BimCommonDto bimCommonDto) {
        return new ResponseEntity<>(standardBimService.create(bimCommonDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody BimCommonDto modifiedBim) {
        return new ResponseEntity<>(standardBimService.update(modifiedBim), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(standardBimService.delete(id),HttpStatus.OK);
    }
}
