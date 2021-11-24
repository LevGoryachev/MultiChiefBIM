package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Estimate - estimated project cost of the construction site or its part
 * @author Lev Goryachev
 * @version 1.1
 */

@Entity
@Table(name = "estimate")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Estimate {
    @Id
    @Column(name = "estimate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estimate_code_number")
    private String estimateCodeNumber;

    @Column(name = "link")
    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstimateCodeNumber() {
        return estimateCodeNumber;
    }

    public void setEstimateCodeNumber(String estimateCodeNumber) {
        this.estimateCodeNumber = estimateCodeNumber;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
