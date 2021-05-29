package javaCamp.hrms.business.abstracts;

import java.util.List;

import javaCamp.hrms.entities.concretes.JobPositions;

public interface JobPositionsService {
	List<JobPositions> getAll();
}
