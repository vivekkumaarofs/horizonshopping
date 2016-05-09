package com.ofs.servlet;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessLogMessage {

	private static Logger logger = LoggerFactory.getLogger(AccessServlet.class);
		 
		public static void main(String args[]) {
		
		try {

			DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			logger.info("YOU are Currently login");
			System.out.println(format.format(date));
		 } catch (Exception e){
			logger.error("Don NOT Reply to this mail-ID",e);
		 }
	 }
}

