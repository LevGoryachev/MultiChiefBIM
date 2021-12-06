package ru.goryachev.multichief.construction.model.dto.projection;

import ru.goryachev.multichief.construction.model.entity.Site;

/**
 * SiteProjection - DTO projection for ResponseDTOs
 * @author Lev Goryachev
 * @version 1.1
 */
public interface SiteProjection {
    Site getId();
    ConstructionProjection getConstruction();
    BimProjection getBim();
    EstimateProjection getEstimate();
}
