package com.ofs.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ofs.exception.AppException;


public class UserJson {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static String toJSON(Object input) {

		try {
			return mapper.writeValueAsString(input);	
		} catch(Exception e) {
			throw new AppException(e);
		}
	}

	public static <T> T fromJSON(String json, Class<T> classes) {

	    try {
			return mapper.readValue(json, classes); 	
		} catch(Exception e) {
			throw new AppException(e);
		}
	}
}


