package com.revature;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;
import com.revature.daos.TaskDao;
import com.revature.daos.TaskPostgres;
import com.revature.models.Employee;
import com.revature.models.Task;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeDao ed = new EmployeePostgres();
		TaskDao td = new TaskPostgres();
		
		// get employee
//		List<Employee> emps = ed.getEmployees();
//		for(Employee e : emps) {
//			System.out.println(e);
//		}
//		System.out.println(ed.getEmployeeByEmail("lnuzzti0@twitter.com"));
//		Employee e = new Employee();
//		e.setName("KevinTest");
//		e.setEmail("SomeEmail1");
//		e.setPassword("badPass1");
//		e.setRole("Clown");
//		e.setSalary(20.0);
//		e.setManager(new Employee(1));
		
//		int genId = ed.addEmployee(e);
//		System.out.println("The generated id is:" + genId);
//		System.out.println(ed.getEmployeeById(genId));
//		System.out.println("Number of rows changed:" + ed.deleteEmployee(genId));
		
		

		//update employee
//		Employee e = new Employee();
//		e.setName("Test2");
//		e.setEmail("test2@test");
//		e.setPassword("pass2test");
//		e.setRole("teacher2");
//		e.setSalary(100.0);
//		e.setManager(new Employee(1));
//		
//		//int genId = ed.addEmployee(e);
//		//System.out.println("The generated id is:" + genId);
//		
//		e.setId(7);
//		e.setName("Jason");
//		e.setEmail("J@gmail.com");
//		e.setPassword("thisismypass");
//		
//		System.out.println(ed.updateEmployee(e));
//		
		
		// get task by id
//		Task t = new Task();
//		t = td.getTaskById(1);
//		System.out.println(t);
		
		// get all tasks
//		List<Task> tasks = td.getTasks();
//		for(Task t : tasks) {
//			System.out.println(t);
//			}
		
//		List<Task> tasks = td.getTaskByEmployeeId(7);
//		for(Task t : tasks) {
//			System.out.println(t);
//			}
		
		// add task
		
		
//		Task t = new Task();
//		Employee e = new Employee();
//		e = ed.getEmployeeById(7);
//		
//
//		
//		t.setName("clean");
//		t.setAssignDate(LocalDate.now());
//		t.setDueDate(LocalDate.now());
//		t.setCompletionStatus("nope");
//		t.setDescription("get it done");
//		t.setAssignedEmployee(e);
//		
//		
//		int genId = td.addTask(t);
//		System.out.println("The generated id is:" + genId);
//		System.out.println(td.getTaskById(genId));
	
	
//	Employee e = new Employee();
//	
//	int genId = td.addEmployee(e);
//	System.out.println("The generated id is:" + genId);
//	System.out.println(td.getEmployeeById(genId));
		//delete task
	//System.out.println("Number of rows changed:" + td.deleteTask(1));
	
	
	//update task
	
	Task t = new Task();
	Employee e = new Employee(7);
	
	t.setId(2);
	
	t.setName("code");
	t.setAssignDate(LocalDate.now());
	t.setDueDate(LocalDate.now());
	t.setCompletionStatus("nope");
	t.setDescription("code project");
	t.setAssignedEmployee(e);
	
	//int genId = ed.addEmployee(e);
	//System.out.println("The generated id is:" + genId);
	
	
	
	System.out.println(td.updateTask(t));
	
	
	}
	
}
