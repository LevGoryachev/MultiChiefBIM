package ru.goryachev.multichief.construction.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.construction.model.entity.Site;
import ru.goryachev.multichief.construction.service.implementation.SpecialSiteService;

import java.util.List;

/**
 * MultiChiefConstruction API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/constructions")
public class SiteController {

    private SpecialSiteService specialSiteService;

    @Autowired
    public SiteController(SpecialSiteService specialSiteService) {
        this.specialSiteService = specialSiteService;
    }

    //All construction-sites form DB
    @GetMapping("/sites")
    public ResponseEntity<List<Site>> getAllSites () {
        return new ResponseEntity<>(specialSiteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/sites/{id}")
    public ResponseEntity<Site> getById (@PathVariable Long id){
        return new ResponseEntity<>(specialSiteService.getById(id), HttpStatus.OK);
    }

    @GetMapping("{constructionId}/sites")
    public ResponseEntity<List<Site>> getAllByConstruction (@PathVariable Long constructionId, @RequestParam (value = "type", required = false) String typeName) {
        return new ResponseEntity<>(specialSiteService.findAllByConstructionWithType(constructionId, typeName), HttpStatus.OK);
    }

  /*  @PostMapping("{constructionId}/sites")
    public ResponseEntity<Object> createItems (@PathVariable Long constructionId, @RequestBody ConstructionSiteRequestDto requestDto) {
        return new ResponseEntity<>(specialSiteService.save(constructionId, requestDto), HttpStatus.CREATED);
    }

    @PutMapping("{constructionId}/sites")
    public ResponseEntity<Object> updateItems (@PathVariable Long constructionId, @RequestBody ConstructionSiteRequestDto modifiedSite) {
        return new ResponseEntity<>(specialSiteService.save(constructionId, modifiedSite), HttpStatus.CREATED);
    }*/

    @DeleteMapping("{constructionId}/sites/{id}")//remove id and implement deleteAllBy
    public ResponseEntity<Object> deleteItems (@PathVariable Long constructionId, @PathVariable Long id) {
        return new ResponseEntity<>(specialSiteService.deleteByConstructionIdAndId(constructionId, id), HttpStatus.OK);
    }
}
