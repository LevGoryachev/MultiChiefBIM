package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

/**
 * Construction - building construction object
 * @author Lev Goryachev
 * @version 1.1
 */

@Entity
@Table(name = "construction")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Construction {
    @Id
    @Column(name = "construction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "object_code_number")
    private String objectCodeNumber;

    @Column(name = "object_name")
    private String objectName;

    @Column(name = "object_description")
    private String objectDescription;

    @Column(name = "is_linear")
    private Boolean isLinear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectCodeNumber() {
        return objectCodeNumber;
    }

    public void setObjectCodeNumber(String objectCodeNumber) {
        this.objectCodeNumber = objectCodeNumber;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectDescription() {
        return objectDescription;
    }

    public void setObjectDescription(String objectDescription) {
        this.objectDescription = objectDescription;
    }

    public Boolean getIsLinear() {
        return isLinear;
    }

    public void setIsLinear(Boolean isLinear) {
        this.isLinear = isLinear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Construction)) return false;
        Construction that = (Construction) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getObjectCodeNumber(), that.getObjectCodeNumber()) &&
                Objects.equals(getObjectName(), that.getObjectName()) &&
                Objects.equals(getObjectDescription(), that.getObjectDescription()) &&
                Objects.equals(getIsLinear(), that.getIsLinear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getObjectCodeNumber(), getObjectName(), getObjectDescription(), getIsLinear());
    }

    @Override
    public String toString() {
        return "Construction{" +
                "id=" + id +
                ", objectCodeNumber='" + objectCodeNumber + '\'' +
                ", objectName='" + objectName + '\'' +
                ", objectDescription='" + objectDescription + '\'' +
                ", isLinear=" + isLinear +
                '}';
    }
}
