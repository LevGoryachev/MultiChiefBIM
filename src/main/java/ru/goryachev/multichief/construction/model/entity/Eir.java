package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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
    private String objectCodeNumber;

    @Column(name = "eir_description")
    private String objectDescription;

    @Column(name = "link")
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
}
