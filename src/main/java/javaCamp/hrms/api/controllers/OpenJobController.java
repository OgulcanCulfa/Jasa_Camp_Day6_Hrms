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

import javaCamp.hrms.business.abstracts.OpenJobService;
import javaCamp.hrms.core.utilities.ErrorDataResult;
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
	public Result register(@Valid @RequestBody OpenJob openJob) {
		return this.openJobService.save(openJob);
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