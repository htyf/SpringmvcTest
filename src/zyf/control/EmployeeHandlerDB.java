package zyf.control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import zyf.dao.IDepartmentDao;
import zyf.dao.IEmployeeDao;
import zyf.dao.impl.DepartmentDao;
import zyf.dao.impl.EmployeeDao;
import zyf.entity.Employee;

@Controller
@RequestMapping("/empsdb")
public class EmployeeHandlerDB {

	@Resource(name="employeeDaoImpl")
	private IEmployeeDao employeeDao;
	@Resource(name="departmentDaoImpl")
	private IDepartmentDao departmentDao;

	
	@RequestMapping("/getAll")
	public String list(Map<String, Object> map) throws Exception{
		map.put("employees", employeeDao.getAll());
		return "list";
	}

	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map) throws Exception{
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(Employee employee) throws Exception{
		employeeDao.save(employee);
		return "redirect:/empsdb/getAll";
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) throws Exception{
		employeeDao.delete(id);
		System.out.println("delete");
		return "redirect:/empsdb/getAll";
	}


	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) throws Exception{
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "edit";
	}

	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map)  throws Exception{
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}

	@RequestMapping(value="/edit", method=RequestMethod.PUT)
	public String update(Employee employee) throws Exception{
		employeeDao.update(employee);
		return "redirect:/empsdb/getAll";
	}

	@ResponseBody
	@RequestMapping("testJson")
	public Collection<Employee> testJson()  throws Exception{
		System.out.println(employeeDao.getAll());
		return employeeDao.getAll();
	}

	/**
	 * 上传文件（这里是图片）
	 * @param file
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("testFileUpload")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
		String path = request.getSession().getServletContext().getRealPath("upload"); 
		String fileName = file.getOriginalFilename();  //图片的原始名称
		//        String fileName = new Date().getTime()+".jpg";  
		System.out.println(path);  
		File targetFile = new File(path, fileName);  
		if(!targetFile.exists()){  
			targetFile.mkdirs();  
		}  
		//保存  
		try {  
			file.transferTo(targetFile); //上传文件到指定文件夹中 
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  

		return "result";  
	}  
	
	/**
	 *  @ResponseBody可以直接返回结果，
		而ResponseEntity 可以定义返回的HttpHeaders和HttpStatus
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
	    byte[] body = null;
	    ServletContext servletContext = session.getServletContext();
	    InputStream in = servletContext.getResourceAsStream("/files/guice.txt");
	    body = new byte[in.available()];
	    in.read(body);
	         
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attachment;filename=guice.txt");
	    HttpStatus statusCode = HttpStatus.OK;
	    ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, statusCode);
	    return response;
	}

}
