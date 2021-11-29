package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectType)) return false;
        ProjectType that = (ProjectType) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTypeName(), that.getTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeName());
    }

    @Override
    public String toString() {
        return "ProjectType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
