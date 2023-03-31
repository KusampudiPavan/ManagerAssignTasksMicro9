package com.stl.ManagerAssignTasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.ManagerAssignTasks.model.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
	

	@Query(value = "select * from tasks where manageremailid=?;", nativeQuery = true)
	public List<TaskModel> findalltasksassigned(String manageremailid);
}
