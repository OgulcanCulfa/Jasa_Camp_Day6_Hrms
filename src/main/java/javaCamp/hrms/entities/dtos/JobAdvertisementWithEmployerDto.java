package javaCamp.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementWithEmployerDto {
	private int id;
	private String companyName;
	private String name;
	private int countOfPosition;
	private Date createdAt;
	private Date applicationDeadline;
}
