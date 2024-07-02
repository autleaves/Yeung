package mil.yaye.yours.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateTimeHelper {
    private static SimpleDateFormat FULL_SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat DFULL_SDF = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat DFULL_SDF_SLASH = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private static SimpleDateFormat FULL_SDF_NOSP = new SimpleDateFormat("yyyyMMddHHmm");
    private static SimpleDateFormat DFULL_SDF_CN = new SimpleDateFormat("yyyy年MM月dd日");
    private static SimpleDateFormat ONLY_TIME = new SimpleDateFormat("HH:mm");
    private static SimpleDateFormat MD_TIME = new SimpleDateFormat("MM-dd");

    public static String getMDTime(Date date){
        if(date!=null){
            return MD_TIME.format(date);
        }else{
            return "";
        }

    }

    public static String getOnlyTime(Date date){
        if(date!=null){
            return ONLY_TIME.format(date);
        }else{
            return "";
        }

    }

    public static String getFullTimeNoSP(Date date){
        if(date!=null){
            return FULL_SDF_NOSP.format(date);
        }else{
            return "";
        }

    }

    public static String getFullTimeTwo(Date date){
        if(date!=null){
            String dateStr = FULL_SDF.format(date);
            return dateStr.substring(2,10);
        }else{
            return "";
        }

    }

    public static String getFullTime(Date date){
        if(date!=null){
            return FULL_SDF.format(date);
        }else{
            return "";
        }
    }
    public static String getDFullTime(Date date){
        if(date!=null){
            return DFULL_SDF.format(date);
        }else{
            return "";
        }
    }
    public static String getDFullTimeSlash(Date date){
        if(date!=null){
            return DFULL_SDF_SLASH.format(date);
        }else{
            return "";
        }
    }
    public static String getDFullTimeCN(Date date){
        if(date!=null){
            return DFULL_SDF_CN.format(date);
        }else{
            return "";
        }
    }

    //以下程序废止
    /**
     * 返回当前时间，iFlag == 0，返回年月日时分秒
     * iFlag == 1，返回年－月－日 时：分：秒
     * iFlag == 2，返回年月日
     * iFlag == 3，返回年－月－日
     * iFlag == 4，返回年－月
     * @param iFlag
     * @return
     */
    private static String getFullTime(int iFlag) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat;
        if (iFlag == 0) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        } else if (iFlag == 1) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (iFlag == 2) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        } else if (iFlag == 3) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else if (iFlag == 4) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        }else if(iFlag==5){
            simpleDateFormat = new SimpleDateFormat("MM-dd");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
        if(date!=null){
            return simpleDateFormat.format(date);
        }else{
            return "";
        }
    }

    /**
     * 解析字符串格式时间为标准格式 iFlag == 0 返回年－月－日 时：分：秒
     * iFlag == 1 返回年－月－日
     * @param sFullTime
     * @param iFlag
     * @return
     */
    private static String getFullTime(String sFullTime, int iFlag) {
        if (sFullTime == null || sFullTime.trim().equals(""))
            return "";

        StringBuffer sDateBuffer = new StringBuffer();
        sDateBuffer.append(sFullTime.substring(0, 4) + "-");
        sDateBuffer.append(sFullTime.substring(4, 6) + "-");
        sDateBuffer.append(sFullTime.substring(6, 8) + " ");
        if (iFlag == 1)
            return sDateBuffer.toString();

        if (iFlag == 2) {
            sDateBuffer.append(sFullTime.substring(8, 10));
            sDateBuffer.append("时");
            return sDateBuffer.toString();
        } else {
            sDateBuffer.append(sFullTime.substring(8, 10) + ":");
        }

        if (iFlag == 3) {
            sDateBuffer.append(sFullTime.substring(10, 12));
            return sDateBuffer.toString();
        } else {
            sDateBuffer.append(sFullTime.substring(10, 12) + ":");
        }

        sDateBuffer.append(sFullTime.substring(12, 14));
        return sDateBuffer.toString();

    }

    /**
     * 返回当前时间的标准格式： 年－月－日 时：分：秒
     * @return
     */
    public static String getStandardFullTime() {
        return getFullTime(1);
    }

    /**
     * 解析字符串格式时间为标准格式 年月日时分秒 -> 年－月－日 时：分：秒
     * @param sFullTime
     * @return
     */
    public static String getStandardFullTime(String sFullTime) {
        return getFullTime(sFullTime, 0);
    }

    /**
     * 返回当前时间的字符串格式：年月日时分秒
     * @return
     */
    public static String getStringFullTime() {
        return getFullTime(0);
    }

    /**
     * 返回当前时间的标准格式：年－月－日
     * @return
     */
    public static String getStandardYearMonthDay() {
        return getFullTime(3);
    }

    /**
     * 返回当前时间的标准格式：年－月－日
     * @return
     */
    public static String getStandardYearMonth() {
        return getFullTime(4);
    }

    public static String getStandardYearMonthDayHour() {
        return getFullTime(5);
    }

    public static String getStandardYearMonthDayHourMinute() {
        return getFullTime(6);
    }

    /**
     * 解析字符串格式时间为标准格式  年月日 -> 年－月－日
     * @param sYearMonthDay
     * @return
     */
    public static String getStandardYearMonthDay(String sYearMonthDay) {
        return getFullTime(sYearMonthDay, 1);
    }

    public static String getStandardYearMonthDayHour(String sFullTime) {
        return getFullTime(sFullTime, 2);
    }

    public static String getStandardYearMonthDayHourMinute(String sFullTime) {
        return getFullTime(sFullTime, 3);
    }

    /**
     * 返回当前时间的字符串格式:年月日
     * @return
     */
    public static String getStringYearMonthDay() {
        return getFullTime(2);
    }

    /**
     * 转换年－月－日 到年月日
     * @param date
     * @return
     */
    public static String parseYearMonthDay(String date) {
        try {
            return date.substring(0, 4) + date.substring(5, 7) +
                    date.substring(8, 10);
        } catch (Exception e) {
            return null;
        }

    }
    public static String getYearMonth(){
        try{
            Date date = new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
            return simpleDateFormat.format(date);
        }catch (Exception e) {
            return "htmledit";
        }
    }

}
