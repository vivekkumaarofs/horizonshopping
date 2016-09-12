package com.ofs.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ofs.exception.AppException;
import com.ofs.model.HorrizonShoppingJson;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;


public class HmsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String servicePackageName = "com.ofs.serviceImpl.";

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");
		String serviceClassName = servicePackageName + request.getParameter("className");
		Object result;
		try {
			Class<?> serviceClazz = Class.forName(serviceClassName);
			Method purchaseList = serviceClazz.getDeclaredMethod("viewPurchaseOrderService");
			Object objServiceClazz = serviceClazz.newInstance();
			result = purchaseList.invoke(objServiceClazz);
			String res = HorrizonShoppingJson.toJSON(result);
			PrintWriter printWriter = response.getWriter();
			printWriter.print(res);
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		String line = null;
		response.setContentType("appilication/json");
		String modelPackageName = "com.ofs.model."+request.getParameter("modelName");
		String serviceClassName = servicePackageName + request.getParameter("className");
		
		try {
			Class<?>serviceClazz = Class.forName(serviceClassName);	
			Class<?> loadapiClass = Class.forName(modelPackageName);
			
			StringBuffer requestJson = new StringBuffer();
				BufferedReader reader = request.getReader();
				while((line = reader.readLine()) !=null)
					requestJson.append(line);
			Method addCategory = serviceClazz.getDeclaredMethod("addMainCategoryService",loadapiClass);
			Object objServiceClazz = serviceClazz.newInstance();
			Object Category  = HorrizonShoppingJson.fromJSON(requestJson.toString(), loadapiClass);
			addCategory.invoke(objServiceClazz,Category);

		} catch(Exception e){
			throw new AppException(e);
		}
	}

}
