package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
	
	//JdbcTemplate jdbctemplate = new  JdbcTemplate();
	
	public List<Task> usernameandpassword(){
		String sql2="select username,password from task1";
		RowMapper<Task> rm = new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int i) throws SQLException {
            Task task1 = new Task();
        
          
           task1.setUsername(rs.getString(1));
           task1.setPassword(rs.getString(2));
           
           
               
          
                return task1;
                
            }
        };
      return  null ;//jdbctemplate.query(sql2, rm);
		
	}

}
