package com.hcl.dprism.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateConverter {
	@Autowired
	HttpServletRequest request;
	
	//private String dateF = "dd-MM-yyyy hh:mm";
	private String dateF = "dd-MM-yyyy";
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateF);
	private Calendar calendar = Calendar.getInstance();
	
	public Long deserialize(String txtDate)
			{

		String dateTimeInMillis = "";

		try {

			String dateFormat = request.getHeader("date_format");
			String timeZone = request.getHeader("time_zone");

			if (dateFormat != null) {
				simpleDateFormat = new SimpleDateFormat(dateFormat);
			}
			if (timeZone != null) {
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
			}
			Date dt = simpleDateFormat.parse(txtDate);
			dateTimeInMillis = String.valueOf(dt.getTime());

		} catch (ParseException ex) {
			dateTimeInMillis = String.valueOf(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis());
		}

		return new Long(dateTimeInMillis);
	}
	
	/**
	 * Long to Date
	 * @param tmpBigInt
	 * @return
	 */
	public String serialize(Long tmpBigInt){

		

			//String dateFormat = request.getHeader("date_format");
			//String timeZone = request.getHeader("time_zone");

			calendar.setTimeInMillis(
					Long.parseLong(String.format("%0$-" + 13 + "s", tmpBigInt.toString()).replace(" ", "0")));

			/*if (dateFormat != null) {
				simpleDateFormat = new SimpleDateFormat(dateFormat);
			}
			if (timeZone != null) {
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
			}

		} 
			jsonGenerator.writeObject(simpleDateFormat.format(calendar.getTime()));
		*/
			return simpleDateFormat.format(calendar.getTime());
	}

}
