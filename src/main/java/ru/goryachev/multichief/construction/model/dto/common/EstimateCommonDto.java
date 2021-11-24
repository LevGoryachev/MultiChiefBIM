package ru.goryachev.multichief.construction.model.dto.common;

import ru.goryachev.multichief.construction.model.dto.CommonDto;

import java.util.Objects;


/**
 * EstimateCommonDto is an intermediate object of the sub-domain Estimate (cost estimate),
 * used for requests and responses (communication between microservices).
 * @author Lev Goryachev
 * @version 1.1
 */

public class EstimateCommonDto implements CommonDto {

    private Long id;

    private String estimateCodeNumber;

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
        if (!(o instanceof EstimateCommonDto)) return false;
        EstimateCommonDto that = (EstimateCommonDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getEstimateCodeNumber(), that.getEstimateCodeNumber()) &&
                Objects.equals(getLink(), that.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEstimateCodeNumber(), getLink());
    }

    @Override
    public String toString() {
        return "EstimateCommonDto{" +
                "id=" + id +
                ", estimateCodeNumber='" + estimateCodeNumber + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
