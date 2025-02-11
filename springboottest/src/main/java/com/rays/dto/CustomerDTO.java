package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_Customer")
public class CustomerDTO extends BaseDTO{
	







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







	@Column(name = "FIRST_NAME", length = 50)
	    private String firstName;

	    @Column(name = "LOCATION")
	    private String location;

	    @Column(name = "PHONE_NUMBER", length = 50)
	    private Long number;

	    @Column(name = "IMPORTANCE", length = 50)
	    private String importance;

		
		  @Override
	    public LinkedHashMap<String, String> orderBY() {
	        LinkedHashMap<String, String> map = new LinkedHashMap<>();
	        map.put("firstName", "asc");
	        return map;
	    }

	    
		  @Override
		    public String getUniqueKey() {
		        return "firstName";
		    }

		    @Override
		    public String getUniqueValue() {
		        return id + "";
		    }

		    @Override
		    public String getLabel() {
		        return "Customer";
		    }


	
	

		@Override
	    public LinkedHashMap<String, Object> uniqueKeys() {
	        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
	        map.put("id", id);
	        return map;
	    }







		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return firstName;
		}

	
	

}
