package zyf.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import zyf.entity.User;

/**
 * 当用户发出请求时，首先访问populateModel方法，返回User对象，model属性的名称没有指定，
 * 它由返回类型隐含表示，如这个方法返回User类型，那么这个model属性的名称是user。
 * 这个例子中model属性名称有返回对象类型隐含表示，model属性对象就是方法的返回值。它无须要特定的参数。
 * 
 * 当然，也可以指定属性名称
 * 
 * 
 * @author yanfangzhang
 *
 */
@Controller
public class Hello2ModelController {
//	@ModelAttribute//不指定属性名称
	@ModelAttribute(value="myUser") //指定属性名称   
	public User populateModel() {    
		User user=new User();  
		user.setName("ray");  
		return user;  
	}    
	@RequestMapping("/helloWorld2")    
	public String helloWorld() {    
		return "helloWorld";    
	}    
}
