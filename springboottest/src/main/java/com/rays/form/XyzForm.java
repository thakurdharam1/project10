package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.XyzDTO;

public class XyzForm extends BaseForm {
	
	
	 @NotEmpty(message = "Please enter the  Name")
	    private String firstName;

	    @PastOrPresent(message = "date of birth must be today or in the past")
	    @NotNull(message = "Please enter date Of birth")
	    private Date dateOfBirth;

	    @NotNull(message = "Please enter the  Phone number")
	    private Long number;
         
	       
	    
	   







		@NotEmpty(message = "Please select a Department")
	    private String department;

	   

	   



	
		

		public String getFirstName() {
			return firstName;
		}










		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}










		public Date getDateOfBirth() {
			return dateOfBirth;
		}










		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}










		public Long getNumber() {
			return number;
		}










		public void setNumber(Long number) {
			this.number = number;
		}










		public String getDepartment() {
			return department;
		}










		public void setDepartment(String department) {
			this.department = department;
		}










		@Override
	    public BaseDTO getDto() {
	        XyzDTO dto = initDTO(new XyzDTO());
	        dto.setFirstName(firstName);
	        dto.setDateOfBirth(dateOfBirth);
	        dto.setNumber(number);
	        dto.setDepartment(department);
	        return dto;
	    }
	

}
