package javaCamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javaCamp.hrms.business.abstracts.UserTypeService;
import javaCamp.hrms.entities.concretes.UserType;

@RestController
@RequestMapping("/api/positions")
public class UserTypeController {
	
	private UserTypeService userTypeService;

	@Autowired
	public UserTypeController(UserTypeService userTypeService) {
		super();
		this.userTypeService = userTypeService;
		
	}
	
	@GetMapping("/getall")
	public List<UserType> getAll() {
		return this.userTypeService.getAll();
	}
	
	


}
