package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.VehicleDTO;

public class VehicleForm extends BaseForm {
	
	
	 @NotEmpty(message = "Please enter the  ownerName")
	    private String ownerName;

	    @PastOrPresent(message = "date of registraion must be today or in the past")
	    @NotNull(message = "Please enter date Of registraion")
	    private Date dateOfRegistarion;

	    @NotNull(message = "Please enter the  number")
	    private Long number;
         
	       
	    
	  





		public String getOwnerName() {
			return ownerName;
		}









		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}









		public Date getDateOfRegistarion() {
			return dateOfRegistarion;
		}









		public void setDateOfRegistarion(Date dateOfRegistarion) {
			this.dateOfRegistarion = dateOfRegistarion;
		}









		public Long getNumber() {
			return number;
		}









		public void setNumber(Long number) {
			this.number = number;
		}









		public String getType() {
			return type;
		}









		public void setType(String type) {
			this.type = type;
		}









		@NotEmpty(message = "Please select a type")
	    private String type;

	   

	   



	
		
		@Override
	    public BaseDTO getDto() {
	        VehicleDTO dto = initDTO(new VehicleDTO());
	        dto.setownerName(ownerName);
	        dto.setDateOfRegistraion(dateOfRegistarion);
	        dto.setnumber(number);
	        dto.settype(type);
	        return dto;
	    }
	

}
