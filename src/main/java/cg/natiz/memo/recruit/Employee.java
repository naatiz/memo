package cg.natiz.memo.recruit;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	private String identifiant;
	private String firstName;
	private String lastName;
	private String email;
	private Date birthDate;

	private String departement;
	private Date recruitmentDate;

	private Employee(String identifiant, String firstName, String lastName,
			String email) {
		this.identifiant = identifiant;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public static Employee build(String identifiant, String firstName,
			String lastName, String email) {
		return new Employee(identifiant, firstName, lastName, email);
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public Employee setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Employee setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Employee setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Employee setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getDepartement() {
		return departement;
	}

	public Employee setDepartement(String departement) {
		this.departement = departement;
		return this;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Employee setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public Date getRecruitmentDate() {
		return recruitmentDate;
	}

	public Employee setRecruitmentDate(Date recruitmentDate) {
		this.recruitmentDate = recruitmentDate;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((identifiant == null) ? 0 : identifiant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		return true;
	}

}
