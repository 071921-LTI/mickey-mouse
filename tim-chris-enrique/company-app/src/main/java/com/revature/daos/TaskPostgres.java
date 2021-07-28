package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Task;
import com.revature.util.ConnectionUtil;

public class TaskPostgres implements TaskDao {

	@Override
	public Task getTaskById(int id) {
		String sql = "select * from tasks where task_id = ?";
		Task task = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); // 1 refers to first ? to parameterize
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int task_id = rs.getInt("task_id");
				String completion_status = rs.getString("completion_status");
				String task_name = rs.getString("task_name");
				String task_description = rs.getString("task_description");
				LocalDate assign_date = rs.getDate("assign_date").toLocalDate();
				LocalDate due_date = rs.getDate("due_date").toLocalDate();
				int empl_id = rs.getInt("empl_id");
				task = new Task(task_id, task_name, task_description ,completion_status, new Employee(empl_id), assign_date, due_date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}

	@Override
	public List<Task> getTasks() {
		
		List<Task> tasks = new ArrayList<>();
				
				try (Connection con = ConnectionUtil.getConnectionFromEnv()){
					String sql = "select * from tasks";
					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery(sql);
					
					while(rs.next()) {
							int task_id = rs.getInt("task_id");
							String completion_status = rs.getString("completion_status");
							String task_name = rs.getString("task_name");
							String task_description = rs.getString("task_description");
							LocalDate assign_date = rs.getDate("assign_date").toLocalDate();
							LocalDate due_date = rs.getDate("due_date").toLocalDate();
							int empl_id = rs.getInt("empl_id");
							Task task = new Task(task_id, task_name, task_description ,completion_status, new Employee(empl_id), assign_date, due_date);
							tasks.add(task);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return tasks;
			}

	@Override
	public int addTask(Task task) {
		int id = -1;
		String sql = "insert into tasks (completion_status, task_name, task_description, assign_date, due_date, empl_id) values (?,?,?,?,?,?) returning task_id;";

		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, task.getCompletionStatus());
			ps.setString(2, task.getName());
			ps.setString(3, task.getDescription());
			ps.setObject(4, task.getAssignDate());
			ps.setObject(5, task.getDueDate());
			ps.setInt(6, task.getAssignedEmployee().getId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("task_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean updateTask(Task task) {
		String sql = "update tasks set completion_status = ?, task_name = ?, task_description = ?, assign_date = ?, due_date = ?, empl_id = ? where task_id = ?";
		int rowsChanged = -1;
				
			try (Connection con = ConnectionUtil.getConnectionFromEnv()){
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(7, task.getId());
					ps.setString(1, task.getCompletionStatus());
					ps.setString(2, task.getName());
					ps.setString(3, task.getDescription());
					ps.setObject(4, task.getAssignDate());
					ps.setObject(5, task.getDueDate());
					ps.setInt(6, task.getAssignedEmployee().getId());
					
					rowsChanged = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(rowsChanged >0) {
					return true;
				} 
				return false;
	}

	@Override
	public int deleteTask(int id) {
		String sql = "delete from tasks where task_id = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsChanged;
	}

	@Override
	public List<Task> getTaskByEmployeeId(int id) {
		List<Task> tasks = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from tasks where empl_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
					int task_id = rs.getInt("task_id");
					String completion_status = rs.getString("completion_status");
					String task_name = rs.getString("task_name");
					String task_description = rs.getString("task_description");
					LocalDate assign_date = rs.getDate("assign_date").toLocalDate();
					LocalDate due_date = rs.getDate("due_date").toLocalDate();
					int empl_id = rs.getInt("empl_id");
					Task task = new Task(task_id, task_name, task_description ,completion_status, new Employee(empl_id), assign_date, due_date);
					tasks.add(task);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

}
