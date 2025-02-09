package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_Bank")
public class BankDTO extends BaseDTO{
	
	 @Column(name = "CUSTOMER_NAME", length = 50)
	    private String customerName;

	    @Column(name = "TRANSCTION_DATE")
	    private Date dateOfTransction;

	    @Column(name = "PHONE", length = 50)
	    private Long phone;

	    @Column(name = "TYPE", length = 50)
	    private String type;

		
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
	        return "Bank";
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
	    public LinkedHashMap<String, Object> uniqueKeys() {
	        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
	        map.put("id", id);
	        return map;
	    }

	
	

}
