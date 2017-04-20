package zyf.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 利用REST风格实现增删改查。
 * 该类中自下而上的实现了查（get）增（post）删（delete）和改（put）的接口
 * 
 * 如何发送put和delete的请求：

    在web.xml中配置HiddenHttpMethodFilter
    发送post请求
    请求中是个隐藏域，name为”_mothod”，value为put或delete

 * 
 * @author yanfangzhang
 *
 */
@Controller
@RequestMapping("/rest")
public class RESTControl {
	@RequestMapping(value="/testRestPut/{id}", method=RequestMethod.PUT)
	public String testRestPut(@PathVariable(value="id") Integer id){
	    System.out.println("test put:" + id);
	    return "success";
	}
	     
	@RequestMapping(value="/testRestDelete/{id}", method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable(value="id") Integer id){
	    System.out.println("test delete:" + id);
	    return "success";
	}
	     
	@RequestMapping(value="/testRestPost/{id}", method=RequestMethod.POST)
	public String testRestPost(@PathVariable(value="id") Integer id){
	    System.out.println("test post: "+id);
	    return "success";
	}
	     
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
	public String testRest(@PathVariable(value="id") Integer id){
	    System.out.println("test get:" + id);
	    return "success";
	}
	
	

}
