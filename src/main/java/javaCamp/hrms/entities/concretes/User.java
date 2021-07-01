package javaCamp.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_users")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "firstname", length = 80)
	@NotBlank(message = "İsim boş olamaz.")
	@NotNull(message = "İsim bilgisi gereklidir.")
	private String firstName;
	@Column(name = "lastName", length = 80)
	@NotBlank(message = "Soyadı boş olamaz")
	@NotNull(message = "Soyad bilgisi gereklidir.")
	private String lastName;
	@Column(name = "tcNo", length = 11)
	@NotBlank(message = "TcNo boş olamaz.")
	@NotNull(message = "TcNo bilgisi gereklidir.")
	private String tcNo;
	@Column(name = "birthdate")
	@Past(message = "Lütfen Doğum günü formatını doğru giriniz.")
	private Date birthdate;
	@Column(name = "email", length = 120)
	@Email(message = "Lütfen E-mail formatını doğru giriniz.")
	@NotBlank(message = "Email boş olamaz.")
	@NotNull(message = "İsim bilgisi gereklidir.")
	private String email;
	@Column(name = "password", length = 120)
	@NotBlank(message = "Şifre boş olamaz.")
	@NotNull(message = "Email bilgisi gereklidir.")
	private String password;
	
	@JsonIgnore
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "user_type_id", referencedColumnName = "id")
	private UserType userType;
}
