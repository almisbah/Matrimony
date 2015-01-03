package com.mycompany.service.handler;



import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.Element;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.HtmlUtils;
import org.w3c.dom.Document;
import com.mycompany.commons.HTTPUtils;
import com.mycompany.entity.Users;
@Controller

@RequestMapping("/lookup")

public class UserLookup implements  LookupServiceInterface, ApplicationContextAware{

	//http://examples.javacodegeeks.com/enterprise-java/spring/jpaorm/spring-hiblernate-mysql-and-maven-showcase/
	HttpServletResponse res;
	
	ApplicationContext context;
	public UserLookup(){
		
	}
	
	@Override
	public Element SaveLookup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> SimpleLookup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> regexLookup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Document> detailedLookup() {
		// TODO Auto-generated method stub
		return null;
	}
	@RequestMapping(value="/fetch",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String displayDetails(@RequestParam("in") String v ,@RequestParam("i") String i,HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String g = HTTPUtils.returnChar(i);
			//NounService s = (NounService) context.getBean("nounService");
			
			/*if(s !=null){				
				String queryString = (s.findEmployeeById(v).getName());
							
				
				return queryString;
			}*/
			return g;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveDetails(@RequestParam("in") String v ,HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("UTF-8");
		try {
			Users o = new Users();
			o.setId(v);
			o.setEmail(request.getParameter("email"));
			o.setName(HTTPUtils.returnChar(request.getParameter("ne")));
			context.getBean("nounService");		
			//NounService s = (NounService) context.getBean("nounService");
			//s.persistEmployee(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (request.getParameter("word"));
	}
	
	@RequestMapping("/testMVC")	
	public String testMVC(){		
		return "index";
	}
	
	public boolean save(HashMap<String,String> v){
	
		return false;
	}
	
	
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.context = arg0;
		// TODO Auto-generated method stub
		
	}
	
}


