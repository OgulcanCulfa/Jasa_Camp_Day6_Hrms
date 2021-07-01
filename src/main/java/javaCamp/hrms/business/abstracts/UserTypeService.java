package javaCamp.hrms.business.abstracts;

import java.util.List;

import javaCamp.hrms.core.utilities.Result;
import javaCamp.hrms.entities.concretes.UserType;

public interface UserTypeService {
	List<UserType> getAll();
	Result save(UserType userType);
}
