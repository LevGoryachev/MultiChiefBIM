package ru.goryachev.multichief.construction.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.EirCommonDto;
import ru.goryachev.multichief.construction.service.implementation.StandardEirService;

import java.util.List;

/**
 * MultiChiefConstruction API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/eirs")
public class EirController {

    private StandardEirService standardEirService;

    @Autowired
    public EirController(StandardEirService standardEirService) {
        this.standardEirService = standardEirService;
    }

    @GetMapping
    public ResponseEntity<List<CommonDto>> getAllEirs () {
        return new ResponseEntity<>(standardEirService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CommonDto> getById (@PathVariable Long id) {
            return new ResponseEntity<>(standardEirService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody EirCommonDto eirCommonDto) {
        return new ResponseEntity<>(standardEirService.create(eirCommonDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody EirCommonDto modifiedEir) {
        return new ResponseEntity<>(standardEirService.update(modifiedEir), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(standardEirService.delete(id), HttpStatus.OK);
    }
}
