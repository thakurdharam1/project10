package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.BankDTO;
import com.rays.dto.BankDTO;

@Repository
public class BankDAOImpl extends BaseDAOImpl<BankDTO> implements BankDAOInt {
	
	 @Override
	    protected List<Predicate> getWhereClause(BankDTO dto, CriteriaBuilder builder, Root<BankDTO> qRoot) {

	        List<Predicate> whereCondition = new ArrayList<>();

	        if (dto.getId() != null && dto.getId() > 0) {
	            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
	        }

	        if (dto.getCustomerName() != null && !dto.getCustomerName().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("customerName"), dto.getCustomerName() + "%"));
	        }

	        if (dto.getDateOfTransction() != null) {
	            whereCondition.add(builder.equal(qRoot.get("dateOfTransction"), dto.getDateOfTransction()));
	        }

	    	if (!isZeroNumber(dto.getPhone())) {
				whereCondition.add(builder.equal(qRoot.get("phone"), dto.getPhone()));
			}
	        if (dto.getType() != null && !dto.getType().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("type"), dto.getType()));
	        }

	        return whereCondition;
	    }

	    @Override
	    public Class<BankDTO> getDTOClass() {
	        return BankDTO.class;
	    }{

	} {

	}
}
