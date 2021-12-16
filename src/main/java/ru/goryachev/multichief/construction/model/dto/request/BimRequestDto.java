package ru.goryachev.multichief.construction.model.dto.request;

/**
 * BimRequestDto is a transfer object for receiving properties of the building information model (project).
 * BimRequestDto is used for request body contains properties and IDs (for one-to-many relations) to create or modify entity of building information model.
 * Service layer checks if exist (BIM and Estimate) and use them in Construction Site domain (to create new or modify Construction Site).
 * @author Lev Goryachev
 * @version 1.1
 */

public class BimRequestDto {

    private Long id;

    private String projectCodeNumber;

    private String projectName;

    private Short lod;

    private Long projectTypeId;

    private Long eirId;

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

    public Long getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Long projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public Long getEirId() {
        return eirId;
    }

    public void setEirId(Long eirId) {
        this.eirId = eirId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
