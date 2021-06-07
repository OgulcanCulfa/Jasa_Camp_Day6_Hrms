package javaCamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.hrms.business.abstracts.OpenJobService;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.OpenJob;


@RestController
@RequestMapping("/api/openJob/")
public class OpenJobController {
	
	private OpenJobService openJobService;
	
	@Autowired
	public OpenJobController(OpenJobService openJobService) {
		super();
		this.openJobService = openJobService;
	}
	
	@GetMapping("getAll")
	public List<OpenJob> getAll() {
		return this.openJobService.getAll();
	}
	
	@PostMapping("add")
	public Result register(@RequestBody OpenJob openJob) {
		return this.openJobService.save(openJob);
	}

}