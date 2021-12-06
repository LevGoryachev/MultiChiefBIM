package ru.goryachev.multichief.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.construction.model.dto.projection.SiteProjection;
import ru.goryachev.multichief.construction.model.entity.Site;

import java.util.List;

/**
 * SiteRepository: CRUD operations of the sub-domain Construction Site.
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site>findByConstructionId(Long constructionId);
    List<Site>findByBimId(Long bimId);
    //List<SiteProjection> findByConstructionId(Long constructionId); //for document/view
    //List<SiteProjection> findByBimId(Long bimId); //for document/view
    //void deleteByConstructionIdAndBimId(Long constructionId, Long bimId);
}
