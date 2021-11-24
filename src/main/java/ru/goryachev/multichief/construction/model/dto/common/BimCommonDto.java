package ru.goryachev.multichief.construction.model.dto.common;

import ru.goryachev.multichief.construction.model.dto.CommonDto;

import java.util.Objects;

/**
 * BimCommonDto is an intermediate object of the sub-domain BIM,
 * used for requests and responses (communication between microservices).
 * @author Lev Goryachev
 * @version 1.1
 */

public class BimCommonDto implements CommonDto {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BimCommonDto)) return false;
        BimCommonDto that = (BimCommonDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getProjectCodeNumber(), that.getProjectCodeNumber()) &&
                Objects.equals(getProjectName(), that.getProjectName()) &&
                Objects.equals(getLod(), that.getLod()) &&
                Objects.equals(getProjectTypeId(), that.getProjectTypeId()) &&
                Objects.equals(getEirId(), that.getEirId()) &&
                Objects.equals(getLink(), that.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjectCodeNumber(), getProjectName(), getLod(), getProjectTypeId(), getEirId(), getLink());
    }

    @Override
    public String toString() {
        return "BimCommonDto{" +
                "id=" + id +
                ", projectCodeNumber='" + projectCodeNumber + '\'' +
                ", projectName='" + projectName + '\'' +
                ", lod=" + lod +
                ", projectTypeId=" + projectTypeId +
                ", eirId=" + eirId +
                ", link='" + link + '\'' +
                '}';
    }
}
