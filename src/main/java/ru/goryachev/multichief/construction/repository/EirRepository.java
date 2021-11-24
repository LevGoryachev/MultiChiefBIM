package ru.goryachev.multichief.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.construction.model.entity.Eir;

/**
 * EirRepository: CRUD operations of the sub-domain Employer's Information Requirements.
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface EirRepository extends JpaRepository<Eir, Long> {

}
