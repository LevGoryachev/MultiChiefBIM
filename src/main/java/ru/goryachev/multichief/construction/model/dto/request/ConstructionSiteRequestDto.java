package ru.goryachev.multichief.construction.model.dto.request;

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
}
