package zyf.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import zyf.entity.User;

/**
 * 对象合并:如果没有指定名称，可以不用注解
 * 对象合并指定对象名称：使用@ModelAttribute("myUser")注解
 * @author yanfangzhang
 *
 */
@Controller
public class Hello3ModelController {
//	@ModelAttribute//不指定属性名称
	@ModelAttribute(value="myUser") //指定返回的对象名称   可以在jsp中直接使用
	public User populateModel() {    
		User user=new User();  
		user.setName("ray");  
		return user;  
	}    
	@RequestMapping("/helloWorld3")    
	public String helloWorld(@ModelAttribute(value="myUser") User user) {  
		user.setAge(32);
		return "helloWorld";    
	}    
}
