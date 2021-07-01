package javaCamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.hrms.business.abstracts.UserTypeService;
import javaCamp.hrms.core.utilities.ErrorResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.core.utilities.SuccessResult;
import javaCamp.hrms.dataAccess.abstracts.UserTypeDao;
import javaCamp.hrms.entities.concretes.UserType;


@Service
public class UserTypeManager implements UserTypeService {
	
	private UserTypeDao userTypeDao;

	@Autowired
	public UserTypeManager(UserTypeDao userTypeDao) {
		super();
		this.userTypeDao = userTypeDao;
	}
	
	public List<UserType> getAll() {
		return this.userTypeDao.findAll();
	}

	@Override
	public Result save(UserType userType) {
		String userTypeName = userType.getName();
		UserType u = this.userTypeDao.getByName(userTypeName);
		if (u != null) {
			return new ErrorResult("Böyle bir kullanıcı tipi zaten var.");
		}
		this.userTypeDao.save(userType);
		return new SuccessResult("Kullanıcı tipi kaydedildi.");
	}
	

}
