package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.XyzDTO;

@Repository
public class XyzDAOImpl extends BaseDAOImpl<XyzDTO> implements XyzDAOInt {
	
	 @Override
	    protected List<Predicate> getWhereClause(XyzDTO dto, CriteriaBuilder builder, Root<XyzDTO> qRoot) {

	        List<Predicate> whereCondition = new ArrayList<>();

	        if (dto.getId() != null && dto.getId() > 0) {
	            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
	        }

	        if (dto.getFirstName() != null && !dto.getFirstName().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
	        }

	        if (dto.getDateOfBirth() != null) {
	            whereCondition.add(builder.equal(qRoot.get("dateOfBirth"), dto.getDateOfBirth()));
	        }

	    	if (!isZeroNumber(dto.getNumber())) {
				whereCondition.add(builder.equal(qRoot.get("number"), dto.getNumber()));
			}
	        if (dto.getDepartment() != null && !dto.getDepartment().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("department"), dto.getDepartment()));
	        }

	        return whereCondition;
	    }

	    @Override
	    public Class<XyzDTO> getDTOClass() {
	        return XyzDTO.class;
	    }{

	} {

	}
}
