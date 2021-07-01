package javaCamp.hrms.business.abstracts;

import java.util.List;

import javaCamp.hrms.core.utilities.DataResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.Employer;
import javaCamp.hrms.entities.dtos.EmployerWithUserTypeDto;

public interface EmployerService {
	List<Employer> getAll();
	Result save(Employer employer);
	DataResult<List<EmployerWithUserTypeDto>> getEmployerWithUserTypeDetails();
}
