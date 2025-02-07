package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="ST_Abc")
public class AbcDTO extends BaseDTO{
	
	 @Column(name = "NAME", length = 50)
	    private String name;

	    @Column(name = "DATEOF_BIRTH")
	    private Date dateOfBirth;

	    @Column(name = "LAST_NAME", length = 50)
	    private String lastName;

	    @Column(name = "BRANCH", length = 50)
	    private String branch;

		
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
	        return "Abc";
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
	    public LinkedHashMap<String, Object> uniqueKeys() {
	        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
	        map.put("id", id);
	        return map;
	    }

	
	

}
