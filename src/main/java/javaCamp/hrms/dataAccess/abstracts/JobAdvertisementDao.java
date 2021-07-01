package javaCamp.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javaCamp.hrms.entities.concretes.JobAdvertisement;
import javaCamp.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	@Query("Select new javaCamp.hrms.entities.dtos.JobAdvertisementWithEmployerDto"
			+ "(j.id, e.companyName, o.name, j.countOfPosition,"
			+ " j.createdAt, j.applicationDeadline)"
			+ " From JobAdvertisement j Inner Join j.employer"
			+ " e Inner Join j.openJob o where j.isActive = true")
	List<JobAdvertisementWithEmployerDto> getJobAdvertisementWithEmployerDetails();
	@Query("Select new javaCamp.hrms.entities.dtos.JobAdvertisementWithEmployerDto"
			+ "(j.id, e.companyName, o.name, j.countOfPosition,"
			+ " j.createdAt, j.applicationDeadline)"
			+ " From JobAdvertisement j Inner Join j.employer"
			+ " e Inner Join j.openJob o where j.isActive = true Order By j.createdAt Desc")
	List<JobAdvertisementWithEmployerDto> getJobAdvertisementWithEmployerDetailsByDate();
	@Query("Select new javaCamp.hrms.entities.dtos.JobAdvertisementWithEmployerDto"
			+ "(j.id, e.companyName, o.name, j.countOfPosition,"
			+ " j.createdAt, j.applicationDeadline)"
			+ " From JobAdvertisement j Inner Join j.employer"
			+ " e Inner Join j.openJob o where e.companyName = :companyName and j.isActive = true")
	List<JobAdvertisementWithEmployerDto> getJobAdvertisementWithEmployerDetailsByCompanyName(@Param("companyName") String companyName);
	@Transactional
	@Modifying
	@Query("Update JobAdvertisement j set j.isActive = :isActive where j.id = :id")
	void setIsActive(@Param("isActive") Boolean isActive, @Param("id") int id);
}
