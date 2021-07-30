package com.mk.demos.mapstruct.fish.model;

/**
 * WaterQualityReport
 *
 * @author WangChen
 * Created on 2021/7/30 10:32
 * @since 0.1
 */
public class WaterQualityReport {

    private String organisationName;
    private String verdict;

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }
}
