package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AssetDTO;

@Repository
public class AssetDAOImpl extends BaseDAOImpl<AssetDTO> implements AssetDAOInt {

    @Override
    protected List<Predicate> getWhereClause(AssetDTO dto, CriteriaBuilder builder, Root<AssetDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (dto.getRegistrationNumber() != null && !dto.getRegistrationNumber().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("registrationNumber"), dto.getRegistrationNumber() + "%"));
        }

        if (dto.getAcquisitionDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("acquisitionDate"), dto.getAcquisitionDate()));
        }

        if (dto.getCoverageAmount() != null) {
            whereCondition.add(builder.equal(qRoot.get("coverageAmount"), dto.getCoverageAmount()));
        }

        if (dto.getPaintColor() != null && !dto.getPaintColor().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("paintColor"), dto.getPaintColor()));
        }

        return whereCondition;
    }

    @Override
    public Class<AssetDTO> getDTOClass() {
        return AssetDTO.class;
    }
}
