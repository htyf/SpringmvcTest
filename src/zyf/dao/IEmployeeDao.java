package zyf.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zyf.entity.Department;
import zyf.entity.Employee;

public interface IEmployeeDao {
    public void save(Employee employee) throws Exception;
    
    public void update(Employee employee) throws Exception;
     
    public Collection<Employee> getAll()  throws Exception;
     
    public Employee get(Integer id)  throws Exception;
     
    public void delete(Integer id)  throws Exception;
    
    public int maxId()  throws Exception;
}
