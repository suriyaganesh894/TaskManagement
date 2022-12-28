package com.webapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.dao.TaskDao;
import com.webapp.demo.task.Task;

@RestController
public class TaskController {
	
	@Autowired
	TaskDao dao;
	
	@RequestMapping("/addTask")
	@ResponseBody
	public void addTask(@RequestParam String id,@RequestParam String name,@RequestParam String date,@RequestParam String taskName,@RequestParam String status,Task obj ) {
		
		obj.setTaskid(id);
		obj.setTaskHolderName(name);
		obj.setTaskDate(date);
		obj.setTaskName(taskName);
		obj.setTaskStatus(status);
		dao.save(obj);
		System.out.println("task added");
		
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public void addTask(@RequestParam String id) {
		
		dao.updateStatus(id);
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteTask(@RequestParam String id) {
		
		dao.deleteTask(id);
		
	}
	
	@RequestMapping("/allTask")
	@ResponseBody
	public List<Task> getAllTask(){
		
		return dao.findAll();
		
	}
	
	@RequestMapping("/getByHolder")
	@ResponseBody
	public List<Task> getTaskByHolderName(@RequestParam String name){
		
		return dao.getTaskByHolder(name);
		
	}
}
