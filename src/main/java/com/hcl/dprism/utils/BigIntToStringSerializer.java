package com.hcl.dprism.utils;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author bikash.k
 *
 */
public class BigIntToStringSerializer extends JsonSerializer<Long> {

	@Autowired
	HttpServletRequest request;

	private String dateF = "dd-MM-yyyy hh:mm";
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateF);
	private Calendar calendar = Calendar.getInstance();
	
	@Override
	public void serialize(Long tmpBigInt, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		try {

			String dateFormat = request.getHeader("date_format");
			String timeZone = request.getHeader("time_zone");

			calendar.setTimeInMillis(
					Long.parseLong(String.format("%0$-" + 13 + "s", tmpBigInt.toString()).replace(" ", "0")));

			if (dateFormat != null) {
				simpleDateFormat = new SimpleDateFormat(dateFormat);
			}
			if (timeZone != null) {
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
			}

		} finally {
			jsonGenerator.writeObject(simpleDateFormat.format(calendar.getTime()));
		}

	}

}
