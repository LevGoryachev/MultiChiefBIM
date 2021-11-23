package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Site - Construction site of certain Construction.
 * (can be of whole construction object or as a point of linear construction object)
 * @author Lev Goryachev
 * @version 1.1
 */

@Entity
@Table(name = "site")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Site {
    @Id
    @Column(name = "site_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "construction_id")
    private Long constructionId;

    @Column(name = "bim_id")
    private Long bimId;

    @Column(name = "estimate_id")
    private Long estimateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConstructionId() {
        return constructionId;
    }

    public void setConstructionId(Long constructionId) {
        this.constructionId = constructionId;
    }

    public Long getBimId() {
        return bimId;
    }

    public void setBimId(Long bimId) {
        this.bimId = bimId;
    }

    public Long getEstimateId() {
        return estimateId;
    }

    public void setEstimateId(Long estimateId) {
        this.estimateId = estimateId;
    }
}
