package javaCamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.hrms.business.abstracts.EmployerService;
import javaCamp.hrms.core.utilities.ErrorResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.core.utilities.SendEmail;
import javaCamp.hrms.core.utilities.SuccessResult;
import javaCamp.hrms.dataAccess.abstracts.EmployerDao;
import javaCamp.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public Result save(Employer employer) {
		if (employer.getCompanyEmail() == null || employer.getCompanyName() == null
				|| employer.getCompanyWebsite() == null || employer.getMobile() == null
				|| employer.getUser().getEmail() == null || employer.getUser().getPassword() == null) {
			return new ErrorResult("Lütfen gerekli alanları doldurunuz.");
		}
		List<Employer> employers = this.getAll();
		for (Employer i : employers) {
			if (i.getCompanyEmail().equals(employer.getCompanyEmail())) {
				return new ErrorResult("Böyle bir işveren zaten mevcut.");
			}
		}
		new SendEmail("Doğrulama maili. url: http://xyz.com");
		this.employerDao.save(employer);
		return new SuccessResult("İşveren kaydedildi.");
	}

}
