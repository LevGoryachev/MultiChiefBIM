package ru.goryachev.multichief.construction.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.ProjectTypeCommonDto;
import ru.goryachev.multichief.construction.service.implementation.StandardProjectTypeService;

import java.util.List;

/**
 * MultiChiefConstruction API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/types")
public class ProjectTypeController {

    private StandardProjectTypeService standardProjectTypeService;

    @Autowired
    public ProjectTypeController(StandardProjectTypeService standardProjectTypeService) {
        this.standardProjectTypeService = standardProjectTypeService;
    }

    @GetMapping
    public ResponseEntity<List<CommonDto>> getAllProjectTypes () {
        return new ResponseEntity<>(standardProjectTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CommonDto> getById (@PathVariable Long id) {
            return new ResponseEntity<>(standardProjectTypeService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody ProjectTypeCommonDto projectTypeCommonDto) {
        return new ResponseEntity<>(standardProjectTypeService.create(projectTypeCommonDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody ProjectTypeCommonDto modifiedProjectType) {
        return new ResponseEntity<>(standardProjectTypeService.update(modifiedProjectType), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(standardProjectTypeService.delete(id), HttpStatus.OK);
    }
}
