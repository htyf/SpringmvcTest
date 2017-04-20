package zyf.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloModelController {
	/**
	 * 访问控制器方法helloWorld时，会首先调用populateModel方法，
	 * 将页面参数abc(/helloWorld.ht?abc=text)放到model的attributeName属性中，
	 * 在视图中可以直接访问。
	 * @RequestParam注解:表示请求的时候必须传的参数
	 * @param abc
	 * @param model
	 */
	@ModelAttribute   
	public void populateModel(@RequestParam String abc, Model model) {    
		model.addAttribute("attributeName", abc);    
	}    

	@RequestMapping("/helloWorld")    
	public String helloWorld(Model model) {
		System.out.println("helloword");
		return "helloWorld";    
	}    
}
