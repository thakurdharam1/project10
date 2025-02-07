package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_XYZ")
public class XyzDTO extends BaseDTO{
	
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







	@Column(name = "FIRST_NAME", length = 50)
	    private String firstName;

	    @Column(name = "BIRTH_DATE")
	    private Date dateOfBirth;

	    @Column(name = "PHONE_NUMBER", length = 50)
	    private Long number;

	    @Column(name = "DEPARTMENT", length = 50)
	    private String department;

		
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
		        return "Xyz";
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
