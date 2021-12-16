package ru.goryachev.multichief.construction.model.dto.response;

import ru.goryachev.multichief.construction.model.entity.ProjectType;

/**
 * BimPreformDTO is a response DTO (preform of a document) - engineering, designe or other type of project for certain building construction.
 * contains a head of document and list of materials (items).
 * @author Lev Goryachev
 * @version 1.1
 */

public class BimPreformDTO {

    private Long id;

    private String projectCodeNumber;

    private String projectName;

    private Short lod;

    private ProjectType projectType;

    private Long projectTypeId;

    private Long eirId;

    private String link;

}
