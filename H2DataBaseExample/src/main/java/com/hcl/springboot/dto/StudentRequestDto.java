package com.hcl.springboot.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class StudentRequestDto {
	
	@NotEmpty(message = "name cannot empty")
	private String name;
	@NotEmpty(message = "course cannot empty")
	private String course;
	@NotEmpty(message = "Department name cannot empty")
	private String department;
	@Email
	private String email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
