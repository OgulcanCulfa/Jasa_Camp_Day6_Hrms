package javaCamp.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import javaCamp.hrms.business.abstracts.UserTypeService;
import javaCamp.hrms.core.utilities.ErrorDataResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.UserType;

@RestController
@RequestMapping("/api/userTypes/")
public class UserTypeController {
	
	private UserTypeService userTypeService;

	@Autowired
	public UserTypeController(UserTypeService userTypeService) {
		super();
		this.userTypeService = userTypeService;
		
	}
	
	@GetMapping("getall")
	public List<UserType> getAll() {
		return this.userTypeService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody UserType userType) {
		return this.userTypeService.save(userType);
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
