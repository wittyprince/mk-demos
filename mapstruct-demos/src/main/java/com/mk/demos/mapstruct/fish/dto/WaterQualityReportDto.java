package com.mk.demos.mapstruct.fish.dto;

/**
 * WaterQualityReportDto
 *
 * @author WangChen
 * Created on 2021/7/30 10:27
 * @since 0.1
 */
public class WaterQualityReportDto {

    private WaterQualityOrganisationDto organisation;
    private String verdict;

    public WaterQualityOrganisationDto getOrganisation() {
        return organisation;
    }

    public void setOrganisation(WaterQualityOrganisationDto organisation) {
        this.organisation = organisation;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }
}
