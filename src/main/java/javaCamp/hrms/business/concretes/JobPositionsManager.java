package javaCamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.hrms.business.abstracts.JobPositionsService;
import javaCamp.hrms.dataAccess.abstracts.JobPositionsDao;
import javaCamp.hrms.entities.concretes.JobPositions;

@Service
public class JobPositionsManager implements JobPositionsService {
	
	private JobPositionsDao jobPositionsDao;

	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}
	
	public List<JobPositions> getAll() {
		return this.jobPositionsDao.findAll();
	}
	

}
