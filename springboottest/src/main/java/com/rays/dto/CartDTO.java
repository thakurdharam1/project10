package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_cart")
public class CartDTO extends BaseDTO{
	
	 @Column(name = "CUSTOMER_NAME", length = 50)
	    private String customerName;

	    @Column(name = "TRANSCTION_DATE")
	    private Date dateOfTransction;

	    @Column(name = "QUANTITY", length = 50)
	    private Long quantity;

	    @Column(name = "PRODUCT", length = 50)
	    private String product;

		
		@Override
	    public String getValue() {
	        return customerName;
	    }
		

	    @Override
	    public String getUniqueKey() {
	        return "customerName";
	    }

	    @Override
	    public String getUniqueValue() {
	        return id + "";
	    }

	    @Override
	    public String getLabel() {
	        return "Cart";
	    }

	    @Override
	    public LinkedHashMap<String, String> orderBY() {
	        LinkedHashMap<String, String> map = new LinkedHashMap<>();
	        map.put("customerName", "asc");
	        return map;
	    }

	    


	
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


		public Long getQuantity() {
			return quantity;
		}


		public void setQuantity(Long quantity) {
			this.quantity = quantity;
		}


		public String getProduct() {
			return product;
		}


		public void setProduct(String product) {
			this.product = product;
		}


		@Override
	    public LinkedHashMap<String, Object> uniqueKeys() {
	        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
	        map.put("id", id);
	        return map;
	    }

	
	

}
