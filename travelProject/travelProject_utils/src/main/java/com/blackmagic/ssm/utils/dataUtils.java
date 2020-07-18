package com.blackmagic.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dataUtils {
    //日期转换成字符串
    public static String date2String(Date date, String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        String format = simpleDateFormat.format(date);
        return format;
    }
    //字符串转换成日期
    public static Date string2Date(String strs,String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        Date parse = simpleDateFormat.parse(strs);
        return parse;
    }
}
