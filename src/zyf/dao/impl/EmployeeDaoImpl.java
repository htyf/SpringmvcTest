package zyf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zyf.dao.IDepartmentDao;
import zyf.dao.IEmployeeDao;
import zyf.entity.Department;
import zyf.entity.Employee;
import zyf.utils.DBConnection;

@Repository("employeeDaoImpl")
public class EmployeeDaoImpl implements IEmployeeDao{

	private  Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

	@Resource(name="departmentDaoImpl") 
	private IDepartmentDao departmentDao;



	public void save(Employee employee) throws Exception{
		int initId = maxId()+1;
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBConnection.getConn();
			String sql = "insert into employee(id,lastName,email,gender,departid) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getEmail());
			ps.setInt(4, employee.getGender());
			ps.setInt(5, employee.getDepartment().getId());


			int rows = ps.executeUpdate();

		}finally{
			DBConnection.closeAll(conn, ps, null);
		}

	}

	public Collection<Employee> getAll() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConn();
			String sql = "select e.id,e.lastName,e.email,e.gender,e.departid from employee e,department d where e.departid=d.id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setLastName(rs.getString("lastName"));
				e.setEmail(rs.getString("email"));
				e.setGender(rs.getInt("gender"));
				e.setDepartment(departmentDao.getDepartment(rs.getInt("departid")));
				employees.put(e.getId(), e);
			}
		}finally{
			DBConnection.closeAll(conn, ps, rs);
		}
		return employees.values();
	}

	public Employee get(Integer id) throws SQLException, Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConn();
			String sql = "select * from employee where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setLastName(rs.getString("lastName"));
				e.setEmail(rs.getString("email"));
				e.setGender(rs.getInt("gender"));
				e.setDepartment(departmentDao.getDepartment(rs.getInt("departid")));
				employees.put(e.getId(), e);
			}
		}finally{
			DBConnection.closeAll(conn, ps, rs);
		}
		return employees.get(id);
	}

	public void delete(Integer id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBConnection.getConn();
			String sql = "delete from employee where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int rows = ps.executeUpdate();

		}finally{
			DBConnection.closeAll(conn, ps, null);
		}
		employees.remove(id);
	}

	@Override
	public int maxId() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int maxid =0;
		try{
			conn = DBConnection.getConn();
			String sql = "select max(id) from employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				maxid=rs.getInt(1);
			}
		}finally{
			DBConnection.closeAll(conn, ps, rs);
		}
		return maxid;
	}

	@Override
	public void update(Employee employee) throws Exception {
		System.out.println(employee);
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBConnection.getConn();
			String sql = "update employee set lastName=?,email=?,gender=?,departid=? where id=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getLastName());
			ps.setString(2, employee.getEmail());
			ps.setInt(3, employee.getGender());
			ps.setInt(4, employee.getDepartment().getId());
			ps.setInt(5, employee.getId());


			int rows = ps.executeUpdate();

		}finally{
			DBConnection.closeAll(conn, ps, null);
		}



	}
}
