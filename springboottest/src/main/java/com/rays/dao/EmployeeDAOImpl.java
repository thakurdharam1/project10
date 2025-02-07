package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.EmployeeDTO;

@Repository
public class EmployeeDAOImpl extends BaseDAOImpl<EmployeeDTO> implements EmployeeDAOInt {
	
	 @Override
	    protected List<Predicate> getWhereClause(EmployeeDTO dto, CriteriaBuilder builder, Root<EmployeeDTO> qRoot) {

	        List<Predicate> whereCondition = new ArrayList<>();

	        if (dto.getId() != null && dto.getId() > 0) {
	            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
	        }

	        if (dto.getName() != null && !dto.getName().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
	        }

	        if (dto.getDateOfJoining() != null) {
	            whereCondition.add(builder.equal(qRoot.get("dateOfJoining"), dto.getDateOfJoining()));
	        }

	        if (dto.getLastName() != null && !dto.getLastName().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("lastName"), dto.getLastName() + "%"));
	        }
	        if (dto.getDepartment() != null && !dto.getDepartment().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("department"), dto.getDepartment()));
	        }

	        return whereCondition;
	    }

	    @Override
	    public Class<EmployeeDTO> getDTOClass() {
	        return EmployeeDTO.class;
	    }{

	} {

	}
}
