package javaCamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javaCamp.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	List<User> getByUserType_id(int userTypeId);
	User findByEmailOrTcNo(String email,String tcNo);
}
