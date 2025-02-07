package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.VehicleDTO;
import com.rays.dto.VehicleDTO;

@Repository
public class VehicleDAOImpl extends BaseDAOImpl<VehicleDTO> implements VehicleDAOInt {
	
	 @Override
	    protected List<Predicate> getWhereClause(VehicleDTO dto, CriteriaBuilder builder, Root<VehicleDTO> qRoot) {

	        List<Predicate> whereCondition = new ArrayList<>();

	        if (dto.getId() != null && dto.getId() > 0) {
	            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
	        }

	        if (dto.getownerName() != null && !dto.getownerName().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("ownerName"), dto.getownerName() + "%"));
	        }

	        if (dto.getDateOfRegistraion() != null) {
	            whereCondition.add(builder.equal(qRoot.get("dateOfRegistarion"), dto.getDateOfRegistraion()));
	        }

	    	if (!isZeroNumber(dto.getnumber())) {
				whereCondition.add(builder.equal(qRoot.get("number"), dto.getnumber()));
			}
	        if (dto.gettype() != null && !dto.gettype().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("type"), dto.gettype()));
	        }

	        return whereCondition;
	    }

	    @Override
	    public Class<VehicleDTO> getDTOClass() {
	        return VehicleDTO.class;
	    }{

	} {

	}
}
