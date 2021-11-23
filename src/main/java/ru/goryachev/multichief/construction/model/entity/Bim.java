package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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
