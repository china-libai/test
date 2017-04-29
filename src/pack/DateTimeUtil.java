package pack;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class DateTimeUtil {

	public static String dateFormat1 = "yyyy-MM-dd HH:mm:ss";
	
	public static void main(String[] args) {
		long l = getDistanceMillisons("2017-04-05 10:15:11");
		System.out.println(l);
		System.out.println(l/1000/60);
		if(l > 60000){
			System.out.println("超时");
		}
	}
	
	
	/**
     * 获取给定时间字符串(yyyy-MM-dd HH:mm:ss)和现在时间的毫秒差值
     * @param dateString
     * @return 返回现在时间减去给定时间的毫秒差
     */
    public static long getDistanceMillisons(String dateString){  
        DateFormat df = new SimpleDateFormat(dateFormat1);  
        Date now = new Date();  
        Date giveDate;  
        long distance = 0l;
        try {  
        	giveDate = df.parse(dateString);  
            long nowLong = now.getTime();  
            long giveLong = giveDate.getTime();  
            
            distance = nowLong - giveLong ;
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return distance;  
    }

}
