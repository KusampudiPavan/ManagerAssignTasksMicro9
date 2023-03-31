package com.stl.ManagerAssignTasks.service;

import java.util.List;

import com.stl.ManagerAssignTasks.model.TaskModel;

public interface TaskService {

	TaskModel addtask(TaskModel taskmodel);
	List<TaskModel> findalltasksassigned(String manageremailid);
}
