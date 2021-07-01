package javaCamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.hrms.business.abstracts.OpenJobService;
import javaCamp.hrms.core.utilities.ErrorResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.core.utilities.SuccessResult;
import javaCamp.hrms.dataAccess.abstracts.OpenJobDao;
import javaCamp.hrms.entities.concretes.OpenJob;

@Service
public class OpenJobManager implements OpenJobService {

	private OpenJobDao openJobDao;

	@Autowired
	public OpenJobManager(OpenJobDao openJobDao) {
		super();
		this.openJobDao = openJobDao;
	}

	@Override
	public List<OpenJob> getAll() {
		return this.openJobDao.findAll();
	}

	@Override
	public Result save(OpenJob openJob) {
		String jobName = openJob.getName();
		OpenJob o = this.openJobDao.getByName(jobName);
		if (o != null) {
			return new ErrorResult("Böyle bir kullanıcı tipi zaten var.");
		}
		this.openJobDao.save(openJob);
		return new SuccessResult("İş pozisyonu kaydedildi.");
	}

}
