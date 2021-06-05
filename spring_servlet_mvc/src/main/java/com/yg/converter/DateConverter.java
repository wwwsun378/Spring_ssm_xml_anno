package com.yg.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/5 16:09
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        //将日期字符串转为 date
        System.out.println("要转换的 str = " + s);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(s);
            System.out.println(simpleDateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("转换后的date =" + date);
        return date;
    }
}
