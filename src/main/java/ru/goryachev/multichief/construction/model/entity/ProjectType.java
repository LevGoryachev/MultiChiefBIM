package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * ProjectType - type of construction project
 * @author Lev Goryachev
 * @version 1.1
 */

@Entity
@Table(name = "project_type")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ProjectType {
    @Id
    @Column(name = "project_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
