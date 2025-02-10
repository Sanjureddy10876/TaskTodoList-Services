package com.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.entity.Task;
import com.todolist.repository.TaskRepository;
import com.todolist.service.TaskService;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
		
	}
	
	@PostMapping
	public ResponseEntity<Task> createtask(@RequestBody Task task){
		return ResponseEntity.ok(taskService.createTask(task));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
		boolean isDeleted =taskService.deleteTaskById(id);
		  if (isDeleted) {
		        return ResponseEntity.ok("Deleted successfully");  
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");  
		    }
	}
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task updatedTask) {
	    return taskRepository.findById(id).map(task -> {
	        task.setTitle(updatedTask.getTitle());
	        task.setDescription(updatedTask.getDescription());
	        task.setDueDate(updatedTask.getDueDate());
	        task.setCompleted(updatedTask.isCompleted());
	        Task savedTask = taskRepository.save(task);
	        return ResponseEntity.ok(savedTask);
	    }).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Task> toggleTaskCompletion(@PathVariable("id")  Long id) {
	    return taskRepository.findById(id).map(task -> {
	        task.setCompleted(!task.isCompleted()); 
	        Task savedTask = taskRepository.save(task);
	        return ResponseEntity.ok(savedTask);
	    }).orElseGet(() -> ResponseEntity.notFound().build());
	}
	


}
