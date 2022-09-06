package com.luiz.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UFT-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return "";
		}
		
	}
	
	public static Date converDate(String texDate, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(texDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return defaultValue;
		}
	}
}
