package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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
}
