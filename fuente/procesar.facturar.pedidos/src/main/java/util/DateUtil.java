package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
	
	public static String getDateCurrent(){
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_YYYY_MM_DD);

		String date = simpleDateFormat.format(new Date());
		return date;
	}

}
