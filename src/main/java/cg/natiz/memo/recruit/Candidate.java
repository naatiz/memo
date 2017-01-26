package cg.natiz.memo.recruit;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Candidate implements Serializable {
	
    private String firstName;     
    private String lastName;      
    private String email;     
    private String skill;   
    private Date birthDate;

    private Candidate(String firstName, String lastName, String email) {
    	this.firstName = firstName; 
    	this.lastName = lastName; 
    	this.email = email;
    }
    
    public static Candidate build(String firstName, String lastName, String email) {
    	return new Candidate(firstName, lastName, email);
    }
    
	public String getFirstName() {
		return firstName;
	}
	public Candidate setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public Candidate setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Candidate setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getSkill() {
		return skill;
	}
	public Candidate setSkill(String skill) {
		this.skill = skill;
		return this;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public Candidate setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Candidate other = (Candidate) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
