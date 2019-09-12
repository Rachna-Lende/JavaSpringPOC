package com.poc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.poc.Employee;

public class EmployeeDao {
	JdbcTemplate template;
	static Logger logger = Logger.getLogger(EmployeeDao.class.getName());
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Employee e){		
		java.sql.Date sDate = new java.sql.Date(e.getDateOfBirth().getTime());	
		String sql="INSERT INTO `POC`.`employee` (`name`, `email`, `dateOfBirth`, `password`) VALUES ('"+e.getName()+"','"+e.getEmail()+"', '"+sDate+"','" +e.getPassword()+"');";    	    
		logger.info("Inserted record of employee "+e);
		return template.update(sql);
	}

	public List<Employee> getEmployees(){    
	    return template.query("SELECT *FROM `employee`",new RowMapper<Employee>(){    
	        public Employee mapRow(ResultSet rs, int row) throws SQLException {    
	        	Employee e=new Employee();    
	            e.setName(rs.getString(1));    
	            e.setEmail(rs.getString(2));    
	            e.setDateOfBirth(rs.getDate(3));    
	            e.setPassword(rs.getString(4));    
	            return e;    
	        }    
	    });    
	}

	public Employee getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		 String sql="select * from employee where name=?";       
	    return template.queryForObject(sql, new Object[]{name},new BeanPropertyRowMapper<Employee>(Employee.class));    
	}

	public int update(Employee emp) {
		java.sql.Date sDate = new java.sql.Date(emp.getDateOfBirth().getTime());
		logger.info("Updated employee");
		 String sql="UPDATE `poc`.`employee` SET `name` = '"+emp.getName()+"',`dateOfBirth` = '"+sDate+"',`password` = '" +emp.getPassword()+"' WHERE `employee`.`email` = '"+emp.getEmail()+"';";  
		 return template.update(sql);    	
	}

	public int delete(String string) {
		// TODO Auto-generated method stub
		String sql1="DELETE FROM `poc`.`employee` WHERE `employee`.`email` = '"+string+"';"; 
		logger.info("Deleted employee");
		return template.update(sql1);
		
	}  
}
