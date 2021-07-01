package javaCamp.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_job_advertisement")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "job_definition")
	@NotBlank(message = "İş tanımı boş olamaz.")
	@NotNull(message = "İş tanımı bilgisi gereklidir.")
	private String jobDefinition;
	@Column(name = "city")
	@NotBlank(message = "Şehir boş olamaz.")
	@NotNull(message = "Şehir bilgisi gereklidir.")
	private String city;
	@Column(name = "min")
	private int min;
	@Column(name = "max")
	private int max;
	@Column(name = "count_of_position")
	@NotNull(message = "Pozisyon sayısı bilgisi gereklidir.")
	@Min(value = 1, message = "Pozisyon sayısı bilgisi 1'den büyük olmalıdır.")
	private int countOfPosition;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "application_deadline")
	@Future(message = "Lütfen ileriki bir tarih bilgisi giriniz.")
	private Date applicationDeadline;
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@ManyToOne()
	@JoinColumn(name = "open_job_id", referencedColumnName = "id")
	@Valid
	private OpenJob openJob;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	private Employer employer;
}
