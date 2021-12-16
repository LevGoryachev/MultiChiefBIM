package ru.goryachev.multichief.construction.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.ConstructionCommonDto;
import ru.goryachev.multichief.construction.model.dto.request.ConstructionSiteRequestDto;
import ru.goryachev.multichief.construction.model.entity.Site;
import ru.goryachev.multichief.construction.service.implementation.SpecialSiteService;
import ru.goryachev.multichief.construction.service.implementation.StandardConstructionService;

import java.util.List;

/**
 * MultiChiefConstruction API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/constructions")
public class UnitedConstructionSiteController {

    private StandardConstructionService standardConstructionService;
    private SpecialSiteService specialSiteService;

    @Autowired
    public UnitedConstructionSiteController(StandardConstructionService standardConstructionService, SpecialSiteService specialSiteService) {
        this.standardConstructionService = standardConstructionService;
        this.specialSiteService = specialSiteService;
    }

    //CRUD of Construction DTO
    @GetMapping
    public ResponseEntity<List<CommonDto>> getAllConstructions () {
        return new ResponseEntity<>(standardConstructionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{constructionId}")
    public ResponseEntity<CommonDto> getConstructionById (@PathVariable Long constructionId) {
            return new ResponseEntity<>(standardConstructionService.getById(constructionId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createConstructions (@RequestBody ConstructionCommonDto constructionCommonDto) {
        return new ResponseEntity<>(standardConstructionService.create(constructionCommonDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateConstructions (@RequestBody ConstructionCommonDto modifiedConstruction) {
        return new ResponseEntity<>(standardConstructionService.update(modifiedConstruction), HttpStatus.OK);
    }

    @DeleteMapping("{constructionId}")
    public ResponseEntity<Object> deleteConstructions (@PathVariable Long constructionId) {
        return new ResponseEntity<>(standardConstructionService.delete(constructionId), HttpStatus.OK);
    }

    //CRUD of Construction-Sites DTO
    //All construction-sites form DB
    @GetMapping("/sites")
    public ResponseEntity<List<Site>> getAllSites () {
        return new ResponseEntity<>(specialSiteService.getAll(), HttpStatus.OK);
    }

    //Get a construction-site regardless of the construction
    @GetMapping("/sites/{siteId}")
    public ResponseEntity<Site> getSiteById (@PathVariable Long siteId){
        return new ResponseEntity<>(specialSiteService.getById(siteId), HttpStatus.OK);
    }

    @GetMapping("{constructionId}/sites")
    public ResponseEntity<List<Site>> getSitesByConstruction (@PathVariable Long constructionId, @RequestParam (value = "type", required = false) String typeName) {
        return new ResponseEntity<>(specialSiteService.findAllByConstructionWithType(constructionId, typeName), HttpStatus.OK);
    }

    @PostMapping("{constructionId}/sites")
    public ResponseEntity<Object> createSites (@PathVariable Long constructionId, @RequestBody ConstructionSiteRequestDto requestDto) {
        return new ResponseEntity<>(specialSiteService.save(constructionId, requestDto), HttpStatus.CREATED);
    }

    @PutMapping("{constructionId}/sites")
    public ResponseEntity<Object> updateSites (@PathVariable Long constructionId, @RequestBody ConstructionSiteRequestDto modifiedSite) {
        return new ResponseEntity<>(specialSiteService.save(constructionId, modifiedSite), HttpStatus.CREATED);
    }

    @DeleteMapping("{constructionId}/sites/{siteId}")//remove id and implement deleteAllBy
    public ResponseEntity<Object> deleteSites (@PathVariable Long constructionId, @PathVariable Long siteId) {
        return new ResponseEntity<>(specialSiteService.deleteByConstructionIdAndId(constructionId, siteId), HttpStatus.OK);
    }
}
