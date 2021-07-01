package javaCamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_employers")
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "company_name", length = 120)
	@NotBlank(message = "Şirket adı boş olamaz.")
	@NotNull(message = "Şirket adı gereklidir.")
	private String companyName;
	@Column(name = "company_website", length = 120)
	@NotBlank(message = "Şirket websitesi boş olamaz.")
	@NotNull(message = "Şirket websitesi gereklidir.")
	private String companyWebsite;
	@Column(name = "company_email", length = 120)
	@Email(message = "Lütfen Email formatını doğru giriniz.")
	@NotBlank(message = "Şirket Email bilgisi boş olamaz.")
	@NotNull(message = "Şirket Email bilgisi boş olamaz.")
	private String companyEmail;
	@Column(name = "mobile", length = 11)
	@NotBlank(message = "Şirket telefon numarası boş olamaz.")
	@NotNull(message = "Şirket telefon numarası boş olamaz.")
	private String mobile;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@Valid
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	

}
