package javaCamp.hrms.entities.dtos;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerWithUserTypeDto {
	private int id;
	private String companyName;
	private String companyWebsite;
	private String companyEmail;
	private String mobile;
	private String firstName;
	private String lastName;
	private String tcNo;
	private Date birthdate;
	private String email;
	private String userTypeName;
}
