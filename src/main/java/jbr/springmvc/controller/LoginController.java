package jbr.springmvc.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class LoginController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());

    return mav;
  }

  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request,Model map,HttpSession hs, HttpServletResponse response,
      @ModelAttribute("login") Login login,Model model
) {
    ModelAndView mav = null;

    User user = userService.validateUser(login);
    if (null != user) {
    	List<User> users= userService.list();
    	if(users.isEmpty()) {
    		System.out.println("empty");
    	}
    	else
    	{
    		System.out.println("presemt");
    	}
      mav = new ModelAndView("welcome");
      mav.addObject("firstname", user.getFirstname());
      mav.addObject("users",users);
      //map.addAttribute("users1",users);
    //  hs.setAttribute("user_list",users);
      
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Username or Password is wrong!!");
    }
    
    userService.marshallUsers();

    
    List<User> usr = new ArrayList<>();
    usr=userService.unmarshallUsers();
    System.out.println(usr);
	model.addAttribute("userlist",usr);
	InputStream inputStream;
	try {
		Properties prop = new Properties();

		String file = "labels.properties";
		
		inputStream = getClass().getClassLoader().getResourceAsStream(file);
		
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + file + "' not found in the classpath");
		}

	    System.out.println(prop.getProperty("label1"));  
	    System.out.println(prop.getProperty("label2")); 
	    System.out.println(prop.getProperty("label_hi_1")); 

	    String lb1=prop.getProperty("label1");
	    String lb2=prop.getProperty("label2");
	    String lb3=prop.getProperty("label3");

	    model.addAttribute("label1",lb1);
	    model.addAttribute("label2",lb2);
	    model.addAttribute("label3",lb3);

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    
     
      
   
    
    return mav;
  }

}
