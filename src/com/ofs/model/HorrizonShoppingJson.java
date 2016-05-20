package com.ofs.model;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.ofs.exception.AppException;


public class HorrizonShoppingJson {

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
	
	public static <T>T fromjson(String json) throws JsonParseException, JsonMappingException, IOException{
		TypeFactory typeFactory = mapper.getTypeFactory();
		MapType mapType = typeFactory.constructMapType(null, Product.class, Category.class);
		return mapper.readValue(json, mapType);

	}
}


