package com.swap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="users")
public class User {

	@Size(min=1,message="Name should not be blank!!")
	private String name;
	@Id
	@Email
	@Size(min=5,message="Invalid Email Address!!")
	private String email;
	
	@Size(min=5,message="Password Must Be atleast 5 digits long!!")
	private String password;
	
	@Size(min=1,message="CompanyName should not be blank!!")
	private String companyname;
	
	@Size(min=1,message="Company Address should not be blank!!")
	private String companyaddress;
	
	@NotNull
	private long mobileno;

	@Size(min=1,message="Skills should not be blank!!")
	private String techskills;
	
	@NotNull
	private int yearsofexperience;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getTechskills() {
		return techskills;
	}

	public void setTechskills(String techskills) {
		this.techskills = techskills;
	}

	public int getYearsofexperience() {
		return yearsofexperience;
	}

	public void setYearsofexperience(int yearsofexperience) {
		this.yearsofexperience = yearsofexperience;
	}

	public User(String name, String email, String password, String companyname, String companyaddress, long mobileno,
			String techskills, int yearsofexperience) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.companyname = companyname;
		this.companyaddress = companyaddress;
		this.mobileno = mobileno;
		this.techskills = techskills;
		this.yearsofexperience = yearsofexperience;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", companyname=" + companyname
				+ ", companyaddress=" + companyaddress + ", mobileno=" + mobileno + ", techskills=" + techskills
				+ ", yearsofexperience=" + yearsofexperience + "]";
	}
	
}
