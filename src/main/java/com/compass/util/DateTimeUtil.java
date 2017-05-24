/**
 * compass. 
 * Copyright � 2015 compass. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF compass. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF compass.
 */
package com.compass.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author TS
 *
 */
public class DateTimeUtil {

	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDaysBetween(Timestamp start, Timestamp end) {

		boolean negative = false;
		if (end.before(start)) {
			negative = true;
			Timestamp temp = start;
			start = end;
			end = temp;
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(start);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		GregorianCalendar calEnd = new GregorianCalendar();
		calEnd.setTime(end);
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, 0);
		calEnd.set(Calendar.MILLISECOND, 0);

		if (cal.get(Calendar.YEAR) == calEnd.get(Calendar.YEAR)) {
			if (negative)
				return (calEnd.get(Calendar.DAY_OF_YEAR) - cal
						.get(Calendar.DAY_OF_YEAR)) * -1;
			return calEnd.get(Calendar.DAY_OF_YEAR)
					- cal.get(Calendar.DAY_OF_YEAR);
		}

		int days = 0;
		while (calEnd.after(cal)) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
			days++;
		}
		if (negative)
			return days * -1;
		return days;
	}
	public static Timestamp convertDateIntoTimeStamp(Date d)
	{
	java.util.Date utilDate = new java.util.Date();
	Calendar cal = Calendar.getInstance();
	cal.setTime(utilDate);
	cal.set(Calendar.MILLISECOND, 0);
	Timestamp tp=new java.sql.Timestamp(utilDate.getTime());
	System.out.println(new java.sql.Timestamp(utilDate.getTime()));
	System.out.println(new java.sql.Timestamp(cal.getTimeInMillis()));
	return tp;
	}
}
