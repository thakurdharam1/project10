package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CartDTO;

public class CartForm extends BaseForm {
	
	
	 @NotEmpty(message = "Please enter the  Name")
	    private String customerName;

	    @PastOrPresent(message = "date of transction must be today or in the past")
	    @NotNull(message = "Please enter date Of transction")
	    private Date dateOfTransction;

	    @NotNull(message = "Please enter the  Quantity")
	    private Long quantity;
         
	       
	    
	    public Long getQuantity() {
			return quantity;
		}








		public void setQuantity(Long quantity) {
			this.quantity = quantity;
		}








		@NotEmpty(message = "Please select a Product")
	    private String product;

	   

	   



	
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








		








		public String getProduct() {
			return product;
		}








		public void setProduct(String product) {
			this.product = product;
		}








		@Override
	    public BaseDTO getDto() {
	        CartDTO dto = initDTO(new CartDTO());
	        dto.setCustomerName(customerName);
	        dto.setDateOfTransction(dateOfTransction);
	        dto.setQuantity(quantity);
	        dto.setProduct(product);
	        return dto;
	    }
	

}
