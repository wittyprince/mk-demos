package com.mk.demos.mapstruct.custom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Date <-> java.lang.String
 * @author WangChen
 * Created on 2021/7/30 11:11
 * @since
 */
public class DateToStringMapper {

    public String asString(Date date) {
        return date != null ? new SimpleDateFormat( "yyyy-MM-dd" )
                .format( date ) : null;
    }

    public Date asDate(String date) {
        try {
            return date != null ? new SimpleDateFormat( "yyyy-MM-dd" )
                    .parse( date ) : null;
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
    }

}
