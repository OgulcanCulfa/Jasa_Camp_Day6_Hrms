package javaCamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.hrms.business.abstracts.EmployerService;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer/")
public class EmployerController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("getAll")
	public List<Employer> getAll() {
		return this.employerService.getAll();
	}
	
	@PostMapping("register") 
		public Result register(@RequestBody Employer employer) {
			return this.employerService.save(employer);
		}	
}
