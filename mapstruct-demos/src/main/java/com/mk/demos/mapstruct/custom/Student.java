package com.mk.demos.mapstruct.custom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * student
 *
 * @author WangChen
 * Created on 2021/7/30 11:08
 * @since 0.1
 */
public class Student {

    private Date birthday;

    private LocalDateTime schoolTime;

    private LocalDateTime graduationTime;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(LocalDateTime schoolTime) {
        this.schoolTime = schoolTime;
    }

    public LocalDateTime getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(LocalDateTime graduationTime) {
        this.graduationTime = graduationTime;
    }
}
