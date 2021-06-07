package javaCamp.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import javaCamp.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
