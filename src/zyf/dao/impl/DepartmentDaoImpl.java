package zyf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import zyf.dao.IDepartmentDao;
import zyf.entity.Department;
import zyf.utils.DBConnection;

@Repository("departmentDaoImpl")
public class DepartmentDaoImpl implements IDepartmentDao{
 
    private  Map<Integer, Department> departments = new HashMap<Integer, Department>();
     
    public Collection<Department> getDepartments() throws SQLException{
    	Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConn();
			String sql = "select * from department";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Department d = new Department();
				d.setId(rs.getInt("id"));
				d.setDepartmentName(rs.getString("departmentName"));
				departments.put(d.getId(), d);
			}
		}finally{
			DBConnection.closeAll(conn, ps, rs);
		}
        return departments.values();
    }
     
    public Department getDepartment(Integer id) throws SQLException{
    	Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConn();
			String sql = "select * from department where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				Department d = new Department();
				d.setId(rs.getInt("id"));
				d.setDepartmentName(rs.getString("departmentName"));
				departments.put(d.getId(), d);
			}
		}finally{
			DBConnection.closeAll(conn, ps, rs);
		}
        return departments.get(id);
    }
     
}
