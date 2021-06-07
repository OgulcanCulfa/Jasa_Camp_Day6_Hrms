package javaCamp.hrms.business.abstracts;

import java.util.List;

import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.OpenJob;

public interface OpenJobService {
	List<OpenJob> getAll();
	Result save(OpenJob openJob);
}
