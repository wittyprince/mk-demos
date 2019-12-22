package com.mk.demos.java8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * zone 时区
 *
 * @author WangChen
 * Created on 2019/12/21 11:24
 * @since 1.0
 */
public class ZoneTest {

    public static void main(String [] args){
        ZoneId romeZone = ZoneId.of("Asia/Shanghai");
        LocalDate date = LocalDate.of(2019, Month.DECEMBER, 21);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        System.out.println(zdt1 + "_" + zdt2 + "_" + zdt3);


        ZoneOffset newYorkOffset = ZoneOffset.of("+08:00");
        LocalDateTime dateTime2 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime2, newYorkOffset);
        System.out.println(dateTimeInNewYork);

    }
}
