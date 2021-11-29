package ru.goryachev.multichief.construction.model.dto.request;

import java.util.Objects;

/**
 * ConstructionSiteRequestDto is a transfer object for receiving properties of the construction site.
 * ConstructionSiteRequestDto is used for request body contains BIM id and Estimate id (to create or modify Construction Site domain).
 * Service layer checks if exist (BIM and Estimate) and use them in Construction Site domain (to create new or modify Construction Site).
 * @author Lev Goryachev
 * @version 1.1
 */

public class ConstructionSiteRequestDto {

    private Long bimId;

    private Long estimateId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConstructionSiteRequestDto)) return false;
        ConstructionSiteRequestDto that = (ConstructionSiteRequestDto) o;
        return Objects.equals(bimId, that.bimId) &&
                Objects.equals(estimateId, that.estimateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bimId, estimateId);
    }
}
