package javaCamp.hrms.business.abstracts;

import java.util.List;

import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getAll();
	Result save(Employer employer);
}
