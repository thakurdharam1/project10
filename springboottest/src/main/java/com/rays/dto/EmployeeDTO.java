package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="ST_EMPLOYEE")
public class EmployeeDTO extends BaseDTO{
	
	 @Column(name = "NAME", length = 20)
	    private String name;

	    @Column(name = "DATEOF_JOINING")
	    private Date dateOfJoining;

	    @Column(name = "LAST_NAME", length = 20)
	    private String lastName;

	    @Column(name = "DEPARTMENT", length = 20)
	    private String department;

		
		@Override
	    public String getValue() {
	        return name;
	    }
		

	    @Override
	    public String getUniqueKey() {
	        return "name";
	    }

	    @Override
	    public String getUniqueValue() {
	        return id + "";
	    }

	    @Override
	    public String getLabel() {
	        return "Employee";
	    }

	    @Override
	    public LinkedHashMap<String, String> orderBY() {
	        LinkedHashMap<String, String> map = new LinkedHashMap<>();
	        map.put("name", "asc");
	        return map;
	    }

	    


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Date getDateOfJoining() {
			return dateOfJoining;
		}


		public void setDateOfJoining(Date dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getDepartment() {
			return department;
		}


		public void setDepartment(String department) {
			this.department = department;
		}


		@Override
	    public LinkedHashMap<String, Object> uniqueKeys() {
	        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
	        map.put("id", id);
	        return map;
	    }

	
	

}
