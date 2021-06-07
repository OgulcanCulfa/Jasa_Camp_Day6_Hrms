package javaCamp.hrms.business.abstracts;

import java.util.List;

import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
	List<User> getByUserType(int userTypeId);
	Result save(User user);
}
