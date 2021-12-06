package ru.goryachev.multichief.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.construction.model.entity.Site;

import java.util.List;

/**
 * SiteRepository: CRUD, select operations of the sub-domain Construction Site.
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site>findByConstructionId(Long constructionId);
    List<Site>findByBimId(Long bimId);

    @Query(value = "SELECT s.* FROM site s LEFT JOIN bim b ON b.bim_id=s.bim_id LEFT JOIN project_type t ON t.project_type_id=b.project_type_id WHERE s.construction_id=?1 AND t.type_name=?2", nativeQuery = true)
    List<Site> findAllByConstructionWithType(Long constructionId, String typeName);

    void deleteByConstructionIdAndId(Long constructionId, Long Id);
}
