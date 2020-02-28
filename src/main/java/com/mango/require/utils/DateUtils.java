package com.mango.require.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @Author: swen
 */
public class DateUtils {

    /**
     * 获取本机现在时间<传入自己想要的时间格式>
     *
     * @return 返回字符串格式yyyy-MM-dd HH:mm:ss
     */
    public static String getLocalTime(String format) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(currentTime);
    }

    /**
     * 两个时间相差秒数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差秒数
     */
    public static int secondOfDate(Date fromDate, Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        long v = to - from;
        return (int) (v / 1000L);
    }

    /**
     * 两个时间相差分钟数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差分钟数
     */
    public static int minuteOfDate(Date fromDate, Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        long v = to - from;
        return (int) (v / 1000L / 60L);
    }

    /**
     * 两个时间相差小时数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差小时数
     */
    public static int hourOfDate(Date fromDate, Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        long v = to - from;
        return (int) (v / 1000L / 60L / 60L);
    }

    /**
     * 两个时间相差天数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差天数
     */
    public static int yearOfDate(Date fromDate, Date toDate) {
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.setTime(fromDate);
        to.setTime(toDate);
        return to.get(Calendar.YEAR) - from.get(Calendar.YEAR);
    }


    /**
     * 两个时间相差月数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差月数
     */
    public static int monthOfDate(Date fromDate, Date toDate) {
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.setTime(fromDate);
        to.setTime(toDate);
        int year = to.get(Calendar.YEAR) - from.get(Calendar.YEAR);
        return (year * 12 + to.get(Calendar.MONTH)) - from.get(Calendar.MONTH);
    }

    /**
     * 两个时间相差年数
     *
     * @param fromDate 开始时间
     * @param toDate   结束时间
     * @return 相差年数
     */
    public static int dayOfDate(Date fromDate, Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        long v = to - from;
        return (int) (v / 1000L / 3600L / 24L);
    }

    /**
     * 在一个时间基础上增加秒数
     *
     * @param date   原时间
     * @param second 秒
     * @return 增加后的时间
     */
    public static Date addSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + second);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加分钟
     *
     * @param date   原时间
     * @param minute 分钟
     * @return 增加后的时间
     */
    public static Date addMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加小时
     *
     * @param date 原时间
     * @param hour 小时
     * @return 增加后的时间
     */
    public static Date addHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加天数
     *
     * @param date 原时间
     * @param day  天数
     * @return 增加后的时间
     */
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + day);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加月数
     *
     * @param date  原时间
     * @param month 月
     * @return 增加后的时间
     */
    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
        return calendar.getTime();
    }

    /**
     * 在一个时间基础上增加年数
     *
     * @param date 原时间
     * @param year 年
     * @return 增加后的时间
     */
    public static Date addYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.MONTH) + year);
        return calendar.getTime();
    }

    /**
     * @param dateStr 日期字符串
     * @return 将String日期转换成 java.util.Date
     * @throws ParseException .
     */
    public static Date strToDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        return dateFormat.parse(dateStr);
    }

    /**
     * @param dateStr 日期字符串
     * @return 将String日期转换成 java.util.Date
     * @throws ParseException .
     */
    public static Date strToDate(String dateStr ,String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.parse(dateStr);
    }

    /**
     * @param date 日期
     * @return 将日期转换成 String ， 格式是 yyyy-MM-dd     *
     */
    public static String dateToStr(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }

    /**
     * @param date 日期
     * @return 将日期转换成 String ， 格式是自定义
     */
    public static String dateToStr(Date date,String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }

    /**
     *  比较日期
     * @param date
     * @param comDate
     * @return
     */
    public static int dateCompareTo(String date,String comDate){
        int compareTo = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateTime = dateFormat.parse(date);
            Date comDateTime = dateFormat.parse(comDate);
            compareTo = dateTime.compareTo(comDateTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return compareTo;
    }

    /**
     * 计算两个时间差
     */
    public static String datePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 通过某个日期来计算所需要的前后多少天的日期
     *
     * @param time
     * @param i
     * @return
     */
    public static String getCalendarTime(String time, int i) throws Exception {
        String times = "";
        // 创建日历类
        Calendar calendar = Calendar.getInstance();
        // 设置一个时间进日历类
        calendar.setTime(strToDate(time,"yyyy-MM-dd"));
        // 设置指定的日期
        calendar.add(Calendar.DATE, i);
        // 通过日历类拿到想要的日期
        Date t = calendar.getTime();
        // 日期转换字符串
        times = dateToStr(t, "yyyy-MM-dd");
        return times;
    }


    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    public static String relativeDateFormat(Date date) {
        long delta = new Date().getTime() - date.getTime();
        if (delta < ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
        }
        if (delta < 45L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < 7L * ONE_DAY) {
            long days = toDays(delta);
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        } else {
            return dateToStr(date, "yyyy-MM-dd");
        }
//        if (delta < 30L * ONE_DAY) {
//            long days = toDays(delta);
//            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
//        }
//        if (delta < 12L * 4L * ONE_WEEK) {
//            long months = toMonths(delta);
//            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
//        } else {
//            long years = toYears(delta);
//            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
//        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }

}
