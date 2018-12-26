package com.hcl.dprism.utils;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author bikash.k
 *
 */
public class StringToBigIntDeserializer extends JsonDeserializer<Long> {
	@Autowired
	HttpServletRequest request;

	private String dateF = "dd-MM-yyyy hh:mm";
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateF);
	
	@Override
	public Long deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException {

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
			Date dt = simpleDateFormat.parse(jp.getText());
			dateTimeInMillis = String.valueOf(dt.getTime());

		} catch (ParseException ex) {
			dateTimeInMillis = String.valueOf(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis());
		}

		return new Long(dateTimeInMillis);
	}
}
