package zyf.control;


import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zyf.entity.User;
import zyf.entity.User1;
/**
 * 1.springmvc匹配请求路径：@RequestMapping
 * RequestMapping可以实现模糊匹配路径，比如：

　　？：匹配一个字符

 *：匹配任意字符

 **：匹配多层路径

 * @author yanfangzhang
 *
 */

@Controller
@RequestMapping("/user")
public class UserControl {
	@RequestMapping("")
	public String Create(Model model) {
		return "create";
	}
	/**
	 * @ModelAttribute("abc"):相当于一个User对象，返回给jsp页面，在jsp中可以直接用abc.属性名
	 * 							获取对象的属性值
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String Save(/*@ModelAttribute("abc") */User user, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
		model.addAttribute("user", user);
		return "detail";
	}

	/**
	 * @PathVariable  该注解用来映射请求URL中绑定的占位符。
	 * 通过@PathVariable可以将URL中占位符的参数绑定到controller处理方法的入参中
	 * 
	 * 页面请求：<a href="user/variable/1">testPathVariable</a><br/><br/>
	 * 通过@PathVariable(value="id")来声明要接收的请求参数，并通过Integer id来绑定和接收。
	 * 最终获取前端页面传入的值
	 * @param id
	 * @return
	 */
	@RequestMapping("/variable/{id}")
	public String testPathVariable(@PathVariable(value="id") Integer id){
		System.out.println("testPathVariable:" + id);
		return "detail";
	} 

	/**
	 * @RequestParam：也是获取请求参数的   用来获取请求中query所带的参数值
	 * 页面请求：<a href="user/param?username=jackie&age=12">testRequestParam</a><br/><br/>
	 * @RequestParam与@PathVariable的区别：
	 * @PathVariable：绑定请求参数
	 * @RequestParam：请求参数是以键值对出现的
	 * @param username
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/param")
	public String testRequestParam(@RequestParam(value="username") String username, @RequestParam(value="age", required=false, defaultValue="0") int age){
		System.out.println("testRequestParam" + " username:" + username + " age:" +age);
		return "detail";
	}

	@RequestMapping(value="/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue){
		System.out.println("testCookieValue: " + cookieValue);
		return "success";
	}
	/**
	 * @RequestHeader：获取的是请求头的信息
	 * @param language
	 * @return
	 */
	@RequestMapping(value="/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String language){
		System.out.println("testRequestHeader Accept-Languge:" + language);
		return "success";
	}

	/**
	 * 请求参数为一个实体类的时候
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/testPojo")
	public String testPojo(User1 user){
		System.out.println("testPojo: " + user);
		return "success";
	}
	
	@RequestMapping(value="/testModelAndView")
	public ModelAndView testModelAndView(){
	    String viewname = "success";
	    ModelAndView modelAndView = new ModelAndView(viewname);
	    modelAndView.addObject("time", new Date());
	    return modelAndView;
	}
	
	@Resource
	private ResourceBundleMessageSource messageSource;
	@RequestMapping("/i18n")
	public String testI18n(Locale locale){
	    String val = messageSource.getMessage("i18n.username", null, locale);
	    System.out.println(val);
	    return "i18n";
	}
	
}
