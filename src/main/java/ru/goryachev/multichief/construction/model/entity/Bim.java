package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

/**
 * Bim - building information model
 * @author Lev Goryachev
 * @version 1.1
 */

@Entity
@Table(name = "bim")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Bim {
    @Id
    @Column(name = "bim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_code_number")
    private String projectCodeNumber;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "lod")
    private Short lod;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_type_id", insertable = false, updatable = false)
    private ProjectType projectType;

    @Column(name = "project_type_id")
    private Long projectTypeId;

    @Column(name = "eir_id")
    private Long eirId;

    @Column(name = "link")
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
        if (!(o instanceof Bim)) return false;
        Bim bim = (Bim) o;
        return Objects.equals(getId(), bim.getId()) &&
                Objects.equals(getProjectCodeNumber(), bim.getProjectCodeNumber()) &&
                Objects.equals(getProjectName(), bim.getProjectName()) &&
                Objects.equals(getLod(), bim.getLod()) &&
                Objects.equals(getProjectType(), bim.getProjectType()) &&
                Objects.equals(getProjectTypeId(), bim.getProjectTypeId()) &&
                Objects.equals(getEirId(), bim.getEirId()) &&
                Objects.equals(getLink(), bim.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjectCodeNumber(), getProjectName(), getLod(), getProjectType(), getProjectTypeId(), getEirId(), getLink());
    }

    @Override
    public String toString() {
        return "Bim{" +
                "id=" + id +
                ", projectCodeNumber='" + projectCodeNumber + '\'' +
                ", projectName='" + projectName + '\'' +
                ", lod=" + lod +
                ", projectType=" + projectType +
                ", projectTypeId=" + projectTypeId +
                ", eirId=" + eirId +
                ", link='" + link + '\'' +
                '}';
    }
}
