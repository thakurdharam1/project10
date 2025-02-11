package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CustomerDTO;

public class CustomerForm extends BaseForm {
	
	
	 @NotEmpty(message = "Please enter the  Name")
	    private String firstName;

	    @NotEmpty(message = "Please enter the location")
	    private String location;

	    @NotNull(message = "Please enter the  Phone number")
	    private Long number;
         
	       
	    
	   







		@NotEmpty(message = "Please select a Importance")
	    private String importance;

	   

	   



	
		

		public String getFirstName() {
			return firstName;
		}










		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}










		
		public String getLocation() {
			return location;
		}










		public void setLocation(String location) {
			this.location = location;
		}










		public Long getNumber() {
			return number;
		}










		public void setNumber(Long number) {
			this.number = number;
		}










		public String getImportance() {
			return importance;
		}










		public void setImportance(String importance) {
			this.importance = importance;
		}










		@Override
	    public BaseDTO getDto() {
	        CustomerDTO dto = initDTO(new CustomerDTO());
	        dto.setFirstName(firstName);
	        dto.setLocation(location);
	        dto.setNumber(number);
	        dto.setImportance(importance);
	        return dto;
	    }
	

}
