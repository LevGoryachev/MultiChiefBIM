package ru.goryachev.multichief.construction.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.construction.model.dto.request.BimRequestDto;
import ru.goryachev.multichief.construction.model.dto.response.BimPreformDTO;
import ru.goryachev.multichief.construction.service.implementation.SpecialBimService;

import java.util.List;

/**
 * MultiChiefConstruction API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/bims")
public class BimController {

    private SpecialBimService specialBimService;

    @Autowired
    public BimController(SpecialBimService specialBimService) {
        this.specialBimService = specialBimService;
    }

    @GetMapping
    public ResponseEntity<List<BimPreformDTO>> getAllBims () {
        return new ResponseEntity<>(specialBimService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<BimPreformDTO> getById (@PathVariable Long id) {
            return new ResponseEntity<>(specialBimService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody BimRequestDto bimRequestDto) {
        return new ResponseEntity<>(specialBimService.save(bimRequestDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody BimRequestDto modifiedBim) {
        return new ResponseEntity<>(specialBimService.save(modifiedBim), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(specialBimService.delete(id), HttpStatus.OK);
    }
}
