package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CartDTO;
import com.rays.dto.CartDTO;

@Repository
public class CartDAOImpl extends BaseDAOImpl<CartDTO> implements CartDAOInt {
	
	 @Override
	    protected List<Predicate> getWhereClause(CartDTO dto, CriteriaBuilder builder, Root<CartDTO> qRoot) {

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

	    	if (!isZeroNumber(dto.getQuantity())) {
				whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
			}
	        if (dto.getProduct() != null && !dto.getProduct().isEmpty()) {
	            whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct()));
	        }

	        return whereCondition;
	    }

	    @Override
	    public Class<CartDTO> getDTOClass() {
	        return CartDTO.class;
	    }{

	} {

	}
}
