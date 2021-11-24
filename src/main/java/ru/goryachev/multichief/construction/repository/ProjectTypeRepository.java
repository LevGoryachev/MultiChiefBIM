package ru.goryachev.multichief.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.construction.model.entity.ProjectType;

/**
 * ProjectTypeRepository: CRUD operations of the sub-domain ProjecType.
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {

}
