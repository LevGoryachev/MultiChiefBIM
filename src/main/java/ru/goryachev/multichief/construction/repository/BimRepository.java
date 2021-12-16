package ru.goryachev.multichief.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.construction.model.dto.projection.BimProjection;
import ru.goryachev.multichief.construction.model.entity.Bim;

import java.util.List;

/**
 * BimRepository: CRUD operations of the sub-domain Building Information Model.
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface BimRepository extends JpaRepository<Bim, Long> {

    //List<BimProjection> findAllBimProjections(); //DTO projection materials with quantities
    //BimProjection findById(Long bimId); //DTO projection materials with quantities
}
