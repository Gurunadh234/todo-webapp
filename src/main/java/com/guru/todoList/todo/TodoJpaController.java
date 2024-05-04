package com.guru.todoList.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guru.todoList.welcome.WelcomeService;

import jakarta.validation.Valid;

@Controller
public class TodoJpaController {
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private WelcomeService welcomeService;
	
	@Autowired
	private TodoRepository todoRepository;
	
	@RequestMapping(value = "list-todos", method = RequestMethod.GET)
	public String showTodosList(ModelMap model) {
		String name = welcomeService.getLoggedInUsername();
		List<Todo> todos = todoRepository.findByUsername(name);
		System.out.println(todos);
		model.put("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		Todo todo = TodoService.getDefaultTodo();
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addTodoToList(ModelMap model, @Valid Todo todo, BindingResult binding) {
		if(binding.hasErrors()) {
			return "addTodo";
		}
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id);
		model.put("todo", todo);
		return "addTodo";
	}
	
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult binding) {
		if(binding.hasErrors()) {
			return "addTodo";
		}
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
