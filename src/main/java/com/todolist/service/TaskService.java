package com.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.Task;
import com.todolist.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	public boolean deleteTaskById(Long id) {
	    if (taskRepository.existsById(id)) {
	        taskRepository.deleteById(id);
	        return true;
	    }
	    return false;
	}

	

}
