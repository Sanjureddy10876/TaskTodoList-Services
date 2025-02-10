package com.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.todolist.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task> findByCompleted(boolean completed);
	
	

}
