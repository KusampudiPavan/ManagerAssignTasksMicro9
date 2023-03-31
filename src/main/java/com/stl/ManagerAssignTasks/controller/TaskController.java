package com.stl.ManagerAssignTasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.ManagerAssignTasks.model.TaskModel;
import com.stl.ManagerAssignTasks.service.TaskService;

@RestController
@RequestMapping("task")
@CrossOrigin("http://localhost:3000")
public class TaskController {

	@Autowired
	TaskService taskservice;
	
	@PostMapping("/add")
	public TaskModel addtask(@RequestBody TaskModel taskmodel) {
		return taskservice.addtask(taskmodel);
	}
	
	@GetMapping("/get/{manageremailid}")
	public List<TaskModel> findalltasksassigned(@PathVariable("manageremailid") String manageremailid){
		return taskservice.findalltasksassigned(manageremailid);
	}
}
