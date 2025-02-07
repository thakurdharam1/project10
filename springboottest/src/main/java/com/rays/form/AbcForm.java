package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AbcDTO;

public class AbcForm extends BaseForm {
	
	
	 @NotEmpty(message = "Please enter the  Name")
	    private String name;

	    @PastOrPresent(message = "date Of Birth must be today or in the past")
	    @NotNull(message = "Please enter date Of Birth")
	    private Date dateOfBirth;

	    @NotEmpty(message = "Please enter the  Last Name")
	    private String lastName;

	    @NotEmpty(message = "Please select a Branch")
	    private String branch;

	   

	   



		public String getName() {
			return name;
		}







		public void setName(String name) {
			this.name = name;
		}







		





		public String getLastName() {
			return lastName;
		}







		public void setLastName(String lastName) {
			this.lastName = lastName;
		}







		







		public Date getDateOfBirth() {
			return dateOfBirth;
		}







		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}







		public String getBranch() {
			return branch;
		}







		public void setBranch(String branch) {
			this.branch = branch;
		}







		@Override
	    public BaseDTO getDto() {
	        AbcDTO dto = initDTO(new AbcDTO());
	        dto.setName(name);
	        dto.setDateOfBirth(dateOfBirth);
	        dto.setLastName(lastName);
	        dto.setBranch(branch);
	        return dto;
	    }
	

}
