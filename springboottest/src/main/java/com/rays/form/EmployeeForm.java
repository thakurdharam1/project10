package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EmployeeDTO;

public class EmployeeForm extends BaseForm {
	
	
	@NotEmpty(message = "Please enter  First name")
	private String name;

	    @PastOrPresent(message = "date Of Joining must be today or in the past")
	    @NotNull(message = "Please enter date Of Joining")
	    private Date dateOfJoining;

	    @NotEmpty(message = "Please enter the  Last Name")
	    private String lastName;

	    @NotEmpty(message = "Please select a Department")
	    private String department;

	   

	   



		public String getName() {
			return name;
		}







		public void setName(String name) {
			this.name = name;
		}







		public Date getDateOfJoining() {
			return dateOfJoining;
		}







		public void setDateOfJoining(Date dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}







		public String getLastName() {
			return lastName;
		}







		public void setLastName(String lastName) {
			this.lastName = lastName;
		}







		public String getDepartment() {
			return department;
		}







		public void setDepartment(String department) {
			this.department = department;
		}







		@Override
	    public BaseDTO getDto() {
	        EmployeeDTO dto = initDTO(new EmployeeDTO());
	        dto.setName(name);
	        dto.setDateOfJoining(dateOfJoining);
	        dto.setLastName(lastName);
	        dto.setDepartment(department);
	        return dto;
	    }
	

}
