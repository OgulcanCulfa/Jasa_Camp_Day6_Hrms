package javaCamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name="tbl_open_jobs")
public class OpenJob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name", length = 255)
	@NotBlank(message = "İş pozisyonu boş olamaz.")
	@NotNull(message = "İş pozisyonu bilgisi gereklidir.")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "openJob")
	private List<JobAdvertisement> jobAdvertisements;
	
}

