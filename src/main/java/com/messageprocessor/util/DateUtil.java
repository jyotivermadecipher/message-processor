package com.messageprocessor.util;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class DateUtil {

    private DateUtil() {}

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    private static final String DATE_FORMAT_BACKEND = "dd-MMM-yy HH:mm:ss";
    private static final String DATE_FORMAT_CHARTS = "yyyy-MM-dd";

    public static String formatStringToCharts(String date){
        SimpleDateFormat backSdf = new SimpleDateFormat(DATE_FORMAT_BACKEND);
        SimpleDateFormat frontSdf = new SimpleDateFormat(DATE_FORMAT_CHARTS);
        try {
            return frontSdf.format(backSdf.parse(date));
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return StringUtils.EMPTY;
    }

}
