package com.devglan.untility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    final String YYYYMMDDHHMMSS = "yyyymmddhhmmss";
    static public String getCurrentTimeStamp(){

        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

    }
}
