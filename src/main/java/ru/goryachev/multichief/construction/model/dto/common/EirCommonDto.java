package ru.goryachev.multichief.construction.model.dto.common;

import ru.goryachev.multichief.construction.model.dto.CommonDto;

import java.util.Objects;

/**
 * EirCommonDto is an intermediate object of the sub-domain EIR (employer's information requirements),
 * used for requests and responses (communication between microservices).
 * @author Lev Goryachev
 * @version 1.1
 */

public class EirCommonDto implements CommonDto {

    private Long id;

    private String objectCodeNumber;

    private String objectDescription;

    private String link;

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

    public String getObjectDescription() {
        return objectDescription;
    }

    public void setObjectDescription(String objectDescription) {
        this.objectDescription = objectDescription;
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
        if (!(o instanceof EirCommonDto)) return false;
        EirCommonDto that = (EirCommonDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getObjectCodeNumber(), that.getObjectCodeNumber()) &&
                Objects.equals(getObjectDescription(), that.getObjectDescription()) &&
                Objects.equals(getLink(), that.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getObjectCodeNumber(), getObjectDescription(), getLink());
    }

    @Override
    public String toString() {
        return "EirCommonDto{" +
                "id=" + id +
                ", objectCodeNumber='" + objectCodeNumber + '\'' +
                ", objectDescription='" + objectDescription + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
