package javaCamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.hrms.business.abstracts.UserTypeService;
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
	

}
