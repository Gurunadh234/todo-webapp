package com.guru.todoList.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 1;
	private static Todo defaultTodo = new Todo(0, "guru", "", null, false);
	static {
		todos.add(new Todo(todoCount++, "gurunadh", "Learn spring", LocalDate.now().plusMonths(1), false));
		todos.add(new Todo(todoCount++, "gurunadh", "Learn spring boot", LocalDate.now().plusMonths(2), false));
		todos.add(new Todo(todoCount++, "guru", "Learn React", LocalDate.now().plusMonths(4), false));
		
	}
	
	public static Todo getDefaultTodo() {
		return defaultTodo;
	}
	public static List<Todo> getTodos() {
		return todos;
	}
	
	public void addTodo(Todo todo) {
		todos.add(new Todo(todoCount++, "guru", todo.getDescription(), todo.getTargetDate(), false));
	}
	
	public void deleteById(int id) {
		todos.removeIf(todo -> todo.getId()==id);
	}
	
	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
		List<Todo> todosList = todos.stream()
									.filter(predicate)
									.toList();
		return todosList;
	}
	
	public Todo findById(int id) {
		return todos.stream()
					.filter(todo -> todo.getId()==id)
					.findFirst()
					.get();
	}
	
	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
