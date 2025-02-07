package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_Vehicle")
public class VehicleDTO extends BaseDTO{
	
	 @Column(name = "owner_NAME", length = 50)
	    private String ownerName;

	    @Column(name = "Registraion_DATE")
	    private Date dateOfRegistraion;

	    @Column(name = "number", length = 4)
	    private Long number;

	    @Column(name = "type", length = 50)
	    private String type;

		
		@Override
	    public String getValue() {
	        return ownerName;
	    }
		

	    @Override
	    public String getUniqueKey() {
	        return "ownerName";
	    }

	    @Override
	    public String getUniqueValue() {
	        return id + "";
	    }

	    @Override
	    public String getLabel() {
	        return "Vehicle";
	    }

	    @Override
	    public LinkedHashMap<String, String> orderBY() {
	        LinkedHashMap<String, String> map = new LinkedHashMap<>();
	        map.put("ownerName", "asc");
	        return map;
	    }

	    


	
		public String getownerName() {
			return ownerName;
		}


		public void setownerName(String ownerName) {
			this.ownerName = ownerName;
		}


		public Date getDateOfRegistraion() {
			return dateOfRegistraion;
		}


		public void setDateOfRegistraion(Date dateOfRegistraion) {
			this.dateOfRegistraion = dateOfRegistraion;
		}


		public Long getnumber() {
			return number;
		}


		public void setnumber(Long number) {
			this.number = number;
		}


		public String gettype() {
			return type;
		}


		public void settype(String type) {
			this.type = type;
		}


		@Override
	    public LinkedHashMap<String, Object> uniqueKeys() {
	        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
	        map.put("id", id);
	        return map;
	    }

	
	

}
