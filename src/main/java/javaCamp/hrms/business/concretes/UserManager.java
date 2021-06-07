package javaCamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.hrms.business.abstracts.UserService;
import javaCamp.hrms.core.utilities.ErrorResult;
import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.core.utilities.SuccessResult;
import javaCamp.hrms.dataAccess.abstracts.UserDao;
import javaCamp.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	public List<User> getByUserType(int userTypeId) {
		
		return this.userDao.getByUserType_id(userTypeId);
	}
	
	public List<User> getAll() {
		return this.userDao.findAll();
	}


	@Override
	public Result save(User user) {;
		String email = user.getEmail();
		String tcNo = user.getTcNo();
		User u = this.userDao.getByEmailOrTcNo(email, tcNo);
		if (u != null) {
			return new ErrorResult("Bu kullanıcı zaten kayıtlı.");
		}
		
		this.userDao.save(user);
		System.out.println("worked");
		return new SuccessResult("Kullanıcı eklendi.");
	}


}
