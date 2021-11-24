package ru.goryachev.multichief.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.construction.model.entity.Site;

/**
 * SiteRepository: CRUD operations of the sub-domain Construction Site.
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

}
