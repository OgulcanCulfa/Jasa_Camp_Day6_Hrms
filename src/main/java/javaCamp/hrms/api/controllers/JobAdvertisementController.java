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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.hrms.business.abstracts.JobAdvertisementService;
import javaCamp.hrms.core.utilities.DataResult;
import javaCamp.hrms.core.utilities.ErrorDataResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.JobAdvertisement;
import javaCamp.hrms.entities.dtos.JobAdvertisementWithEmployerDto;


@RestController
@RequestMapping("/api/jobAdvertisement/")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("getAll")
	public List<JobAdvertisement> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("getJobAdvertisementWithEmployerDetails")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails() {
		return this.jobAdvertisementService.getJobAdvertisementWithEmployerDetails();
	}
	
	@GetMapping("getJobAdvertisementWithEmployerByCreatedAtDesc")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetailsByCreatedAt() {
		return this.jobAdvertisementService.getJobAdvertisementWithEmployerDetailsByDate();
	}
	
	@GetMapping("getJobAdvertisementWithEmployerByCompanyName")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetailsByCompanyName(@RequestParam String companyName) {
		return this.jobAdvertisementService.getJobAdvertisementWithEmployerDetailsByCompanyName(companyName);
	}
	

	@PostMapping("add")
	public Result add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		// tokendan userId alınacak.
		jobAdvertisement.getEmployer().setId(1);
		return this.jobAdvertisementService.save(jobAdvertisement);
	}
	
	@PutMapping("setIsActive")
	public Result setIsActive(@RequestParam Boolean isActive,@RequestBody int id) {
		//id tokendan alınacak.
		return this.jobAdvertisementService.setIsActive(isActive, id);
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

