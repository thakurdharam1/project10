package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AbcDTO;

@Repository
public class AbcDAOImpl extends BaseDAOImpl<AbcDTO> implements AbcDAOInt {
	
	 @Override
	    protected List<Predicate> getWhereClause(AbcDTO dto, CriteriaBuilder builder, Root<AbcDTO> qRoot) {

	        List<Predicate> whereCondition = new ArrayList<>();

	        if (dto.getId() != null && dto.getId() > 0) {
	            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
	        }

	        if (dto.getName() != null && !dto.getName().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
	        }

	        if (dto.getDateOfBirth() != null) {
	            whereCondition.add(builder.equal(qRoot.get("dateOfBirth"), dto.getDateOfBirth()));
	        }

	        if (dto.getLastName() != null && !dto.getLastName().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("lastName"), dto.getLastName() + "%"));
	        }
	        if (dto.getBranch() != null && !dto.getBranch().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("branch"), dto.getBranch()));
	        }

	        return whereCondition;
	    }

	    @Override
	    public Class<AbcDTO> getDTOClass() {
	        return AbcDTO.class;
	    }{

	} {

	}
}
