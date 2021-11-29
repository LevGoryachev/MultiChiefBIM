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

    private String eirCodeNumber;

    private String eirDescription;

    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEirCodeNumber() {
        return eirCodeNumber;
    }

    public void setEirCodeNumber(String eirCodeNumber) {
        this.eirCodeNumber = eirCodeNumber;
    }

    public String getEirDescription() {
        return eirDescription;
    }

    public void setEirDescription(String eirDescription) {
        this.eirDescription = eirDescription;
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
                Objects.equals(getEirCodeNumber(), that.getEirCodeNumber()) &&
                Objects.equals(getEirDescription(), that.getEirDescription()) &&
                Objects.equals(getLink(), that.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEirCodeNumber(), getEirDescription(), getLink());
    }

    @Override
    public String toString() {
        return "EirCommonDto{" +
                "id=" + id +
                ", eirCodeNumber='" + eirCodeNumber + '\'' +
                ", eirDescription='" + eirDescription + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
