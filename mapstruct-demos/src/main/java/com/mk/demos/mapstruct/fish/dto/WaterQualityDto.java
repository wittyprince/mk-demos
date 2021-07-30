package com.mk.demos.mapstruct.fish.dto;

/**
 * WaterQualityDto
 *
 * @author WangChen
 * Created on 2021/7/30 10:26
 * @since 0.1
 */
public class WaterQualityDto {

    private WaterQualityReportDto report;

    public WaterQualityReportDto getReport() {
        return report;
    }

    public void setReport(WaterQualityReportDto report) {
        this.report = report;
    }
}
