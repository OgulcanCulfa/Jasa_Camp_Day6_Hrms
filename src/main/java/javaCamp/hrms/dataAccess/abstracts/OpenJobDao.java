package javaCamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaCamp.hrms.entities.concretes.OpenJob;

public interface OpenJobDao extends JpaRepository<OpenJob, Integer> {
	OpenJob getByName(String name);
}
