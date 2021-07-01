package javaCamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.hrms.business.abstracts.JobAdvertisementService;
import javaCamp.hrms.core.utilities.DataResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.core.utilities.SuccessDataResult;
import javaCamp.hrms.core.utilities.SuccessResult;
import javaCamp.hrms.dataAccess.abstracts.JobAdvertisementDao;
import javaCamp.hrms.entities.concretes.JobAdvertisement;
import javaCamp.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public List<JobAdvertisement> getAll() {
		return this.jobAdvertisementDao.findAll();
	}

	@Override
	public Result save(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı kaydedildi.");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetails() {

		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(
				this.jobAdvertisementDao.getJobAdvertisementWithEmployerDetails(), "Data retrieved.");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetailsByDate() {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(
				this.jobAdvertisementDao.getJobAdvertisementWithEmployerDetailsByDate(), "Data retrieved. Desc");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementWithEmployerDetailsByCompanyName(
			String companyName) {

		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(
				this.jobAdvertisementDao.getJobAdvertisementWithEmployerDetailsByCompanyName(companyName),
				"Data retrieved.");
	}

	@Override
	public Result setIsActive(Boolean isActive, int id) {
		
		this.jobAdvertisementDao.setIsActive(isActive, id);
		return new SuccessResult("Active status updated.");
	}

}
