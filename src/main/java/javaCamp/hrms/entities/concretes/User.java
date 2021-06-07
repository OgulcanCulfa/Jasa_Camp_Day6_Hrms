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
	@Column(name = "firstname", length = 80,nullable = false)
	private String firstName;
	@Column(name = "lastName", length = 80,nullable = false)
	private String lastName;
	@Column(name = "tcNo", length = 11,nullable = false)
	private String tcNo;
	@Column(name = "birthdate",nullable = false)
	private Date birthdate;
	@Column(name = "email", length = 120,nullable = false)
	private String email;
	@Column(name = "password", length = 120,nullable = false)
	private String password;
	
	@JsonIgnore
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "user_type_id", referencedColumnName = "id")
	private UserType userType;
}
