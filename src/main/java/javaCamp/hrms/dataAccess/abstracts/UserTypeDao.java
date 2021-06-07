package javaCamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaCamp.hrms.entities.concretes.UserType;

public interface UserTypeDao extends JpaRepository<UserType, Integer> {

}
