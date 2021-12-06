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

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "construction_id", insertable = false, updatable = false)
    private Construction construction;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "bim_id", insertable = false, updatable = false)
    private Bim bim;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "estimate_id", insertable = false, updatable = false)
    private Estimate estimate;

  /*  @Column(name = "construction_id")
    private Long constructionId;

    @Column(name = "bim_id")
    private Long bimId;

    @Column(name = "estimate_id")
    private Long estimateId;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Construction getConstruction() {
        return construction;
    }

    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    public Bim getBim() {
        return bim;
    }

    public void setBim(Bim bim) {
        this.bim = bim;
    }

    public Estimate getEstimate() {
        return estimate;
    }

    public void setEstimate(Estimate estimate) {
        this.estimate = estimate;
    }
}
