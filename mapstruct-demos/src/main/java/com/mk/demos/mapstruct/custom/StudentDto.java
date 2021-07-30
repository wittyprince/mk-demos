package com.mk.demos.mapstruct.custom;

import java.time.LocalDate;

/**
 * student dto
 *
 * @author WangChen
 * Created on 2021/7/30 11:08
 * @since 0.1
 */
public class StudentDto {
    private String birthday;
    private LocalDate schoolTime;
    private Long graduationTime;
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public LocalDate getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(LocalDate schoolTime) {
        this.schoolTime = schoolTime;
    }

    public Long getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Long graduationTime) {
        this.graduationTime = graduationTime;
    }
}
