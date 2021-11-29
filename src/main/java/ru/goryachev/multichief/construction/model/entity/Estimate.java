package ru.goryachev.multichief.construction.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estimate)) return false;
        Estimate estimate = (Estimate) o;
        return Objects.equals(getId(), estimate.getId()) &&
                Objects.equals(getEstimateCodeNumber(), estimate.getEstimateCodeNumber()) &&
                Objects.equals(getLink(), estimate.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEstimateCodeNumber(), getLink());
    }

    @Override
    public String toString() {
        return "Estimate{" +
                "id=" + id +
                ", estimateCodeNumber='" + estimateCodeNumber + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
