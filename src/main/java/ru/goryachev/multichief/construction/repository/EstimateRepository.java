package ru.goryachev.multichief.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.construction.model.entity.Estimate;

/**
 * EstimateRepository: CRUD operations of the sub-domain Estimate (estimated project cost).
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface EstimateRepository extends JpaRepository<Estimate, Long> {

}
