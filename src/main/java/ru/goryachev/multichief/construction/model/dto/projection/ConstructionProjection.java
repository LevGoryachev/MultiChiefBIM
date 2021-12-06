package ru.goryachev.multichief.construction.model.dto.projection;
/**
 * ConstructionProjection - DTO projection for ResponseDTOs
 * @author Lev Goryachev
 * @version 1.1
 */
public interface ConstructionProjection {
    Long getId();
    String getObjectCodeNumber();
    String getObjectName();
    String getObjectDescription();
    Boolean getIsLinear();
}
