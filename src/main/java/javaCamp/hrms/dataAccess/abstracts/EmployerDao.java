package javaCamp.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javaCamp.hrms.entities.concretes.Employer;
import javaCamp.hrms.entities.dtos.EmployerWithUserTypeDto;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	@Query("Select new javaCamp.hrms.entities.dtos.EmployerWithUserTypeDto"
			+ "(e.id, e.companyWebsite, e.companyName, e.companyEmail,"
			+ " e.mobile, u.firstName, u.lastName, u.tcNo, u.birthdate, u.email, u.userType.name)"
			+ " From Employer e Inner Join e.user u")
	List<EmployerWithUserTypeDto> getEmployerWithUserTypeDetails();
}
