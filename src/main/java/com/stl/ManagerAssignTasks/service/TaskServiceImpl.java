package com.stl.ManagerAssignTasks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.ManagerAssignTasks.model.TaskModel;
import com.stl.ManagerAssignTasks.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskrepo;

	@Override
	public TaskModel addtask(TaskModel taskmodel) {
		return taskrepo.save(taskmodel);
	}

	@Override
	public List<TaskModel> findalltasksassigned(String manageremailid) {
		return taskrepo.findalltasksassigned(manageremailid);
	}
}
