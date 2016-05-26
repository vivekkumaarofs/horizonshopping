package com.ofs.test;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpMethod;
import org.testng.annotations.DataProvider;
import java.sql.Date;
import java.util.List;

import org.testng.annotations.Test;
import com.ofs.DAO.UserDAO;
import com.ofs.DAOImpl.UserDAOImpl;
import com.ofs.exception.AppException;
import com.ofs.model.Product;
import com.ofs.model.User;
import com.ofs.serviceImpl.ProductServiceImpl;
import com.ofs.serviceImpl.UserServiceImpl;

public class TestNgUserDAOImpl {

//	@Test(dataProvider = "sdpCreate")	
//	public void testCreate(User a) {
//		
//		try {
//			UserDAO userimp  =new UserDAOImpl();
//			userimp.addUser(a);			
//		} catch (Exception e) {
//			throw new AppException(e);
//		}
//	}
//	
//	@DataProvider
//	public Object[][] sdpCreate() {
//		return new Object[][] {
//			new Object[] { new User("Satish", Date.valueOf("1993-01-01"), "sat234", "pass123", 
//									"male", "tnagar", "chennai", 600002, "user", "sat1993@gmail.com")} 
//		};
//	}

//	@Test
//	public void testreadall() {
//		try {
//			UserDAOImpl userimpl = new UserDAOImpl();
//			userimpl.readAllUser();
//
//		} catch(Exception e) {
//			throw new AppException(e);
//		}
//	}

//	@Test
//	public void readOneuser() {
//		try {
//			UserDAOImpl userimpl = new UserDAOImpl();
//			User user = userimpl.readOneUser(1);
//			System.out.println(user.toString());
//
//		} catch(Exception e) {
//			throw new AppException(e);
//		}
//	}

	
//@Test(dataProvider= "sdpcreate")
//public void testreadone (String input)  {
//
//	try {
//		HttpClient httpClient = new HttpClient();	
//		httpClient.start();
//		ContentResponse response = httpClient.newRequest("http://localhost:8080/horizon/login")
//											.content(new StringContentProvider(input))
//											 .method(HttpMethod.GET)
//											 .send();
//		System.out.println(response.getStatus());
//		System.out.println(response); 
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//@DataProvider
//public Object[][] sdpcreate() {
//	
//	return new  Object[][] {
//		new Object[] {" {\"id\": 1}"} 
//	};
//}

	
	
//	@Test
//	public void testReadall() {
//
//		try {
//			HttpClient httpClient = new HttpClient();
//			httpClient.start();
//			ContentResponse response = httpClient.newRequest("http://localhost:8080/horizon/Signup")
//									         .method(HttpMethod.GET)
//									         .send();
//			log(response.getStatus());
//			log(response); 
//		} catch (Exception e) {
//			throw new AppException(e);
//		}
//	}

//	@Test
//	public void testLogin() {
//
//		try {
//			HttpClient httpClient = new HttpClient();
//			httpClient.start();
//			ContentResponse response = httpClient.newRequest("http://localhost:8080/onlineshop/Demo")
//									         .method(HttpMethod.GET)
//									         .send();
//			log(response.getStatus());
//			log(response); 
//		} catch (Exception e) {
//			throw new AppException(e);
//		}
//	}

	@Test
	public void testLogin() {

		try {

			HttpClient httpClient = new HttpClient();
			httpClient.start();
			ContentResponse response = httpClient.newRequest("http://localhost:8080/horizon/login")
			         							 .param("username", "vivek234")
			         							 .param("password", "pass123")
			         							 .method(HttpMethod.POST)
			         							 .send();
			log(response.getStatus());
			log(response);
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

//	@Test(dataProvider = "sdpCreate")	
//	public void testCreate(String a , String b) {
//		
//		try {
//			UserServiceImpl userimp  =new UserServiceImpl();
//			userimp.loginService(a,b);			
//		} catch (Exception e) {
//			throw new AppException(e);
//		}
//	}
//	
//	@DataProvider
//	public Object[][] sdpCreate() {
//		return new Object[][] {
//			new Object[] { "ram123","pass123"} 
//		};
//	}

//@Test(dataProvider= "sdpupdate")
//public void testcreate (String input)  {
//	
//		try {
//			HttpClient httpClient = new HttpClient();	
//			httpClient.start();
//			ContentResponse response = httpClient.newRequest("http://localhost:8080/horizon/login")
//											.content(new StringContentProvider(input))
//												 .method(HttpMethod.PUT)
//												 .send();
//			System.out.println(response.getStatus());
//			System.out.println(response); 
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//	
//
//	@DataProvider
//	public Object[][] sdpupdate() {
//		
//		return new  Object[][] {
//			new Object[] {"{ \" password \" : \" Pass@342 \", \" address \": \" tambaram \", \" city \": \" chennai \", \" pincode \" : 600013 , \"id\": 55 }"} 
//		};
//		}

//	@Test(dataProvider= "productadd")
//	public void testcreate (String input)  {
//		
//		try {
//			HttpClient httpClient = new HttpClient();	
//			httpClient.start();
//			ContentResponse response = httpClient.newRequest("http://localhost:8080/horizon/Product")
//	   	    									.content(new StringContentProvider(input))
//	    										.method(HttpMethod.POST)
//												.send();
//				System.out.println(response.getStatus());
//				System.out.println(response); 
//			} catch(Exception e) {
//					e.printStackTrace();
//			}
//	}
	//"{ \"cId\": 3 ,\" productName \" : \" HE MAN \", \" productPrice \": 200, \" productQty \": 200, \" productDiscount \" : 5 }"
	
	//new Product("HeMAN" ,200,200,5,new Category(3))
//	@DataProvider
//	public Object[][] productadd() {
//		return new  Object[][] {
//			new Object[] { "{ \"cId\": 3 ,\" productName \" : \" HE MAN \", \" productPrice \": 200, \" productQty \": 200, \" productDiscount \" : 5 }" 	} 
//		};
//	}
	
//	@Test(dataProvider= "productadd")
//	public void testcreate (Product p)  {
//			try {
//				ProductServiceImpl userimp  =new ProductServiceImpl();
//				userimp.addProductService(p);			
//			} catch (Exception e) {
//				throw new AppException(e);
//			}
//		
//			}
//		
		
//	@Test(dataProvider= "sdpupdate")
//	public void testcreate (User user)  {
//		try {
//			UserServiceImpl userimp  =new UserServiceImpl();
//			userimp.updateOneUserService(user);			
//		} catch (Exception e) {
//			throw new AppException(e);
//		}
//	
//		}
//	
//	@DataProvider
//	public Object[][] sdpupdate() {
//
//		return new  Object[][] {
//			new Object[] {"{ \"password\": \"Pass@342\",\"address\": \"tambaram\", \"city\": \"chennai\", \"pincode\" : 61111046, \" id \": 55 }"} 
//		};
//		}

	public static void log(Object s) {
		System.out.println(s);
	}

}
