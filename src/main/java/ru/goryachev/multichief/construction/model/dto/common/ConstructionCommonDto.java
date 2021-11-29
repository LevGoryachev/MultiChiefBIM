package ru.goryachev.multichief.construction.model.dto.common;

import ru.goryachev.multichief.construction.model.dto.CommonDto;

import java.util.Objects;

/**
 * ConstructionCommonDto is an intermediate object of the sub-domain Construction,
 * used for requests and responses (communication between microservices).
 * @author Lev Goryachev
 * @version 1.1
 */

public class ConstructionCommonDto implements CommonDto {

    private Long id;

    private String objectCodeNumber;

    private String objectName;

    private String objectDescription;

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
        if (!(o instanceof ConstructionCommonDto)) return false;
        ConstructionCommonDto that = (ConstructionCommonDto) o;
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
        return "ConstructionCommonDto{" +
                "id=" + id +
                ", objectCodeNumber='" + objectCodeNumber + '\'' +
                ", objectName='" + objectName + '\'' +
                ", objectDescription='" + objectDescription + '\'' +
                ", isLinear=" + isLinear +
                '}';
    }
}
