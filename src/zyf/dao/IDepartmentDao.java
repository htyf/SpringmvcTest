package zyf.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import zyf.entity.Department;

public interface IDepartmentDao {
 
     /**
      * 获取所有部门
      * @return
      */
    public Collection<Department> getDepartments() throws Exception;
     /**
      * 根据部门id查找部门
      * @param id
      * @return
      */
    public Department getDepartment(Integer id)  throws Exception;
     
}
