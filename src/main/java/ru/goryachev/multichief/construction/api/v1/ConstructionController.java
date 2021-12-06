package ru.goryachev.multichief.construction.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.ConstructionCommonDto;
import ru.goryachev.multichief.construction.service.implementation.StandardConstructionService;

import java.util.List;

/**
 * MultiChiefConstruction API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/constructions")
public class ConstructionController {

    private StandardConstructionService standardConstructionService;

    @Autowired
    public ConstructionController(StandardConstructionService standardConstructionService) {
        this.standardConstructionService = standardConstructionService;
    }

    @GetMapping
    public ResponseEntity<List<CommonDto>> getAllConstructions () {
        return new ResponseEntity<>(standardConstructionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CommonDto> getById (@PathVariable Long id) {
            return new ResponseEntity<>(standardConstructionService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody ConstructionCommonDto constructionCommonDto) {
        return new ResponseEntity<>(standardConstructionService.create(constructionCommonDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody ConstructionCommonDto modifiedConstruction) {
        return new ResponseEntity<>(standardConstructionService.update(modifiedConstruction), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(standardConstructionService.delete(id), HttpStatus.OK);
    }
}
