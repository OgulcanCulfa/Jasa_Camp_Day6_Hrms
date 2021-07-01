package javaCamp.hrms.business.abstracts;


import java.util.List;

import javaCamp.hrms.core.utilities.DataResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.JobAdvertisement;
import javaCamp.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementService {
	List<JobAdvertisement> getAll();
	Result save(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails();
	DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetailsByDate();
	DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetailsByCompanyName(String companyName);
	Result setIsActive(Boolean isActive, int id);
}