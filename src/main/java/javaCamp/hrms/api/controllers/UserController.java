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

import javaCamp.hrms.business.abstracts.UserService;
import javaCamp.hrms.core.utilities.ErrorDataResult;
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

	@PostMapping("registerJobSeekers")
	public Result registerJobSeekers(@Valid @RequestBody User user) {
		user.getUserType().setId(2);
		user.getUserType().setName("İş Arayan");
		return this.userService.save(user);
	}
	
	@PostMapping("registerPersonel")
	public Result registerPersonel(@Valid @RequestBody User user) {
		user.getUserType().setId(1);
		user.getUserType().setName("Sistem Personeli");
		return this.userService.save(user);
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
