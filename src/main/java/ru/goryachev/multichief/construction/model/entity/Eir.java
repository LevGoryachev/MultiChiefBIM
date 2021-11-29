package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

/**
 * Eir - employer's information requirements for construction project
 * @author Lev Goryachev
 * @version 1.1
 */

@Entity
@Table(name = "eir")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Eir {
    @Id
    @Column(name = "eir_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eir_code_number")
    private String eirCodeNumber;

    @Column(name = "eir_description")
    private String eirDescription;

    @Column(name = "link")
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
        if (!(o instanceof Eir)) return false;
        Eir eir = (Eir) o;
        return Objects.equals(getId(), eir.getId()) &&
                Objects.equals(getEirCodeNumber(), eir.getEirCodeNumber()) &&
                Objects.equals(getEirDescription(), eir.getEirDescription()) &&
                Objects.equals(getLink(), eir.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEirCodeNumber(), getEirDescription(), getLink());
    }

    @Override
    public String toString() {
        return "Eir{" +
                "id=" + id +
                ", eirCodeNumber='" + eirCodeNumber + '\'' +
                ", eirDescription='" + eirDescription + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
