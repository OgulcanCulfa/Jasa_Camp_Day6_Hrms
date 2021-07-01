package javaCamp.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.hrms.core.utilities.DataResult;
import javaCamp.hrms.core.utilities.ErrorDataResult;
import javaCamp.hrms.business.abstracts.EmployerService;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.Employer;
import javaCamp.hrms.entities.dtos.EmployerWithUserTypeDto;

@RestController
@RequestMapping("/api/employer/")
@CrossOrigin
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
	
	@GetMapping("getEmployerWithUserTypeDetails")
	public DataResult<List<EmployerWithUserTypeDto>> getProductWithCategoryDetails() {
		return this.employerService.getEmployerWithUserTypeDetails();
	}

	@PostMapping("registerEmployer")
	public Result registerEmployer(@Valid @RequestBody Employer employer) {
		employer.getUser().getUserType().setId(3);
		return this.employerService.save(employer);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation errors");
		return errors;
	}
}
