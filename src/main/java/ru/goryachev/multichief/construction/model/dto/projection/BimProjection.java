package ru.goryachev.multichief.construction.model.dto.projection;

/**
 * BimProjection - DTO projection for ResponseDTOs
 * @author Lev Goryachev
 * @version 1.1
 */
public interface BimProjection {
    Long getId();
    String getProjectCodeNumber();
    String getProjectName();
    String getLod();
    String getLink();
    //ProjectType getProjectType();
}
