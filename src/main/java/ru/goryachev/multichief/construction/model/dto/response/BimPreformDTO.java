package ru.goryachev.multichief.construction.model.dto.response;

import ru.goryachev.multichief.construction.model.dto.PreformDto;
import ru.goryachev.multichief.construction.model.entity.Eir;
import ru.goryachev.multichief.construction.model.entity.ProjectType;

/**
 * BimPreformDTO is a response DTO (preform of a document) - engineering, designe or other type of project for certain building construction.
 * contains a head of document and list of materials (items).
 * @author Lev Goryachev
 * @version 1.1
 */

public class BimPreformDTO implements PreformDto {

    private Long id;

    private String projectCodeNumber;

    private String projectName;

    private Short lod;

    private ProjectType projectType;

    //private Long projectTypeId;

    private Eir eir;

   // private Long eirId;

    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectCodeNumber() {
        return projectCodeNumber;
    }

    public void setProjectCodeNumber(String projectCodeNumber) {
        this.projectCodeNumber = projectCodeNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Short getLod() {
        return lod;
    }

    public void setLod(Short lod) {
        this.lod = lod;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public Eir getEir() {
        return eir;
    }

    public void setEir(Eir eir) {
        this.eir = eir;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
