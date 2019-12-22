package com.mk.demos.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * NextWorkingDay
 *
 * @author WangChen
 * Created on 2019/12/21 11:12
 * @since 1.0
 */
public class NextWorkingDay implements TemporalAdjuster {


    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
        else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }

    public static void main(String [] args){
        LocalDate date = LocalDate.of(2019, 12, 21);
        LocalDate with = date.with(new NextWorkingDay());
        System.out.println(with);
    }
}
