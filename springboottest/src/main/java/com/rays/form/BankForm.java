package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BankDTO;

public class BankForm extends BaseForm {
	
	
	 @NotEmpty(message = "Please enter the  Name")
	    private String customerName;

	    @PastOrPresent(message = "date of transction must be today or in the past")
	    @NotNull(message = "Please enter date Of transction")
	    private Date dateOfTransction;

	    @NotNull(message = "Please enter the  phone")
	    private Long phone;
         
	       
	    
	  







		@NotEmpty(message = "Please select a type")
	    private String type;

	   

	   



	
		public String getCustomerName() {
			return customerName;
		}








		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}








		public Date getDateOfTransction() {
			return dateOfTransction;
		}








		public void setDateOfTransction(Date dateOfTransction) {
			this.dateOfTransction = dateOfTransction;
		}








		








		







		public Long getPhone() {
			return phone;
		}








		public void setPhone(Long phone) {
			this.phone = phone;
		}








		public String getType() {
			return type;
		}








		public void setType(String type) {
			this.type = type;
		}








		@Override
	    public BaseDTO getDto() {
	        BankDTO dto = initDTO(new BankDTO());
	        dto.setCustomerName(customerName);
	        dto.setDateOfTransction(dateOfTransction);
	        dto.setPhone(phone);
	        dto.setType(type);
	        return dto;
	    }
	

}
