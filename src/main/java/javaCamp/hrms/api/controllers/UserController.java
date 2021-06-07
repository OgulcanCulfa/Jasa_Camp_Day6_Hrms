package javaCamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.hrms.business.abstracts.UserService;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("getAll")
	public List<User> getAll() {
		return this.userService.getAll();
	}
	
	@GetMapping("getEmployers")
	public List<User> getEmployers() {
		return this.userService.getByUserType(3);
	}
	
	@GetMapping("getJobSeekers")
	public List<User> getJobSeekers() {
		return this.userService.getByUserType(2);
	}
	
	@PostMapping("register")
	public Result register(@RequestBody User user) {
		return this.userService.save(user);
	}
	
	
	

}
