package javaCamp.hrms.business.abstracts;

import java.util.List;

import javaCamp.hrms.entities.concretes.UserType;

public interface UserTypeService {
	List<UserType> getAll();
}
