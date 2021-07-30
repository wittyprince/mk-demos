package com.mk.demos.mapstruct.custom;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * LocalDate <-> LocalDateTime
 * @author WangChen
 * Created on 2021/7/30 11:15
 * @since
 */
public class LocalDateTimeMapper {

    public LocalDateTime localDateToLocalDateTime(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0, 0);
    }

    public LocalDate localDateTimeToLocalDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return LocalDate.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth());
    }

    public Long localDateTimeToLong(LocalDateTime localDateTime){
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public Long localDateTimeToLong(LocalDateTime localDateTime, String zoneId){
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(zoneId));
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public LocalDateTime longToLocalDateTime(Long millis){
//        LocalDateTime localDateTime = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
    }

    public LocalDateTime longToLocalDateTime(Long millis, String zoneId){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.of(zoneId));
    }

}
