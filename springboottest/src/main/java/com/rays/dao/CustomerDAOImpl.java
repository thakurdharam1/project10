package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl extends BaseDAOImpl<CustomerDTO> implements CustomerDAOInt {
	
	 @Override
	    protected List<Predicate> getWhereClause(CustomerDTO dto, CriteriaBuilder builder, Root<CustomerDTO> qRoot) {

	        List<Predicate> whereCondition = new ArrayList<>();

	        if (dto.getId() != null && dto.getId() > 0) {
	            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
	        }

	        if (dto.getFirstName() != null && !dto.getFirstName().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
	        }

	        if (dto.getLocation() != null && !dto.getLocation().isEmpty()) {
	            whereCondition.add(builder.equal(qRoot.get("location"), dto.getLocation()));
	        }

	    	if (!isZeroNumber(dto.getNumber())) {
				whereCondition.add(builder.equal(qRoot.get("number"), dto.getNumber()));
			}
	        if (dto.getImportance() != null && !dto.getImportance().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("importance"), dto.getImportance()));
	        }

	        return whereCondition;
	    }

	    @Override
	    public Class<CustomerDTO> getDTOClass() {
	        return CustomerDTO.class;
	    }{

	} {

	}
}
