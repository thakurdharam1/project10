 package com.rays.common;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.rays.exception.DuplicateRecordException;

/**
 * Suraj Sahu
 * 
 * @param <T> the type of the DTO that extends BaseDTO
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Finds a record by a unique key.
     * 
     * @param attribute the name of the attribute
     * @param val the value of the attribute
     * @param userContext the context of the user making the request
     * @return the found record
     */
    public T findByUniqueKey(String attribute, Object val, UserContext userContext) {
        Class<T> dtoClass = getDTOClass();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(dtoClass);
        Root<T> qRoot = cq.from(dtoClass);
        Predicate condition = builder.equal(qRoot.get(attribute), val);
        if (userContext != null && !isZeroNumber(userContext.getOrgId())) {
            Predicate conditionGrp = builder.equal(qRoot.get("orgId"), userContext.getOrgId());
            cq.where(condition, conditionGrp);
        } else {
            cq.where(condition);
        }
        TypedQuery<T> query = entityManager.createQuery(cq);
        List<T> list = query.getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * Finds a record by primary key.
     * 
     * @param pk the primary key
     * @param userContext the context of the user making the request
     * @return the found record
     */
    public T findByPK(long pk, UserContext userContext) {
        return entityManager.find(getDTOClass(), pk);
    }

    /**
     * Builds a criteria query.
     * 
     * @param dto the data transfer object
     * @param userContext the context of the user making the request
     * @return the typed query
     */
    protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(getDTOClass());
        Root<T> qRoot = cq.from(getDTOClass());
        cq.select(qRoot);
        List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);
        if (dto.isGroupFilter()) {
            whereClause.add(builder.equal(qRoot.get("orgId"), dto.getOrgId()));
        }
        cq.where(whereClause.toArray(new Predicate[0]));
        List<Order> orderBys = getOrderByClause(dto, builder, qRoot);
        cq.orderBy(orderBys.toArray(new Order[0]));
        return entityManager.createQuery(cq);
    }

    /**
     * Creates the WHERE clause for a search query.
     * 
     * @param dto the data transfer object
     * @param builder the criteria builder
     * @param qRoot the root of the query
     * @return the list of predicates
     */
    protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

    /**
     * Searches for records with pagination.
     * 
     * @param dto the data transfer object
     * @param pageNo the page number
     * @param pageSize the page size
     * @param userContext the context of the user making the request
     * @return the list of records
     */
    public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
        TypedQuery<T> query = createCriteria(dto, userContext);
        if (pageSize > 0) {
            query.setFirstResult(pageNo * pageSize);
            query.setMaxResults(pageSize);
        }
        return query.getResultList();
    }

    /**
     * Searches for records without pagination.
     * 
     * @param dto the data transfer object
     * @param userContext the context of the user making the request
     * @return the list of records
     */
    public List<T> search(T dto, UserContext userContext) {
        return search(dto, 0, 0, userContext);
    }

    /**
     * Executes an HQL query.
     * 
     * @param hql the HQL query string
     * @param userContext the context of the user making the request
     * @return the list of results
     */
    public List<?> runHQL(String hql, UserContext userContext) {
        Query q = entityManager.createQuery(hql);
        return q.getResultList();
    }

    /**
     * Retrieves a merit list from an HQL query.
     * 
     * @param hql the HQL query string
     * @param userContext the context of the user making the request
     * @return the list of results
     */
    public List<?> marksheetMeritList(String hql, UserContext userContext) {
        Query q = entityManager.createQuery(hql);
        q.setFirstResult(0);
        q.setMaxResults(10);
        return q.getResultList();
    }

    /**
     * Adds a new record.
     * 
     * @param dto the data transfer object
     * @param userContext the context of the user making the request
     * @return the ID of the newly added record
     */
    public long add(T dto, UserContext userContext) {
        dto.setCreatedBy(userContext.getLoginId());
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedBy(userContext.getLoginId());
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
        dto.setOrgId(userContext.getOrgId());
        dto.setOrgName(userContext.getOrgName());
        populate(dto, userContext);
        entityManager.persist(dto);
        return dto.getId();
    }

    /**
     * Populates redundant values into the data transfer object.
     * 
     * @param dto the data transfer object
     * @param userContext the context of the user making the request
     */
    protected void populate(T dto, UserContext userContext) {
        // To be overridden by subclasses
    }

    /**
     * Updates an existing record.
     * 
     * @param dto the data transfer object
     * @param userContext the context of the user making the request
     */
    public void update(T dto, UserContext userContext) {
        dto.setModifiedBy(userContext.getLoginId());
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
        populate(dto, userContext);
        entityManager.merge(dto);
    }

    /**
     * Checks for duplicate records based on unique keys.
     * 
     * @param dto the data transfer object
     * @param userContext the context of the user making the request
     */
    private void checkDuplicate(T dto, UserContext userContext) {
        LinkedHashMap<String, Object> uniqueKeys = dto.uniqueKeys();
        if (uniqueKeys == null) {
            return;
        }
        uniqueKeys.forEach((key, value) -> {
            T dtoExist = findByUniqueKey(key, value, userContext);
            if (dtoExist != null && dto.getId() != dtoExist.getId()) {
                throw new DuplicateRecordException(key + " already exists");
            }
        });
    }

    /**
     * Deletes a record.
     * 
     * @param dto the data transfer object
     * @param userContext the context of the user making the request
     */
    public void delete(T dto, UserContext userContext) {
        entityManager.remove(dto);
    }

    /**
     * Gets the DTO class object.
     * 
     * @return the DTO class object
     */
    public abstract Class<T> getDTOClass();

    /**
     * Checks if a string is empty.
     * 
     * @param val the string to check
     * @return true if the string is empty, false otherwise
     */
    protected boolean isEmptyString(String val) {
        return val == null || val.trim().isEmpty();
    }

    /**
     * Checks if a number is zero.
     * 
     * @param val the number to check
     * @return true if the number is zero, false otherwise
     */
    protected boolean isZeroNumber(Double val) {
        return val == null || val == 0;
    }

    /**
     * Checks if a number is zero.
     * 
     * @param val the number to check
     * @return true if the number is zero, false otherwise
     */
    protected boolean isZeroNumber(Long val) {
        return val == null || val == 0;
    }

    /**
     * Checks if a number is zero.
     * 
     * @param val the number to check
     * @return true if the number is zero, false otherwise
     */
    protected boolean isZeroNumber(Integer val) {
        return val == null || val == 0;
    }

    /**
     * Checks if an object is not null.
     * 
     * @param val the object to check
     * @return true if the object is not null, false otherwise
     */
    protected boolean isNotNull(Object val) {
        return val != null;
    }

    /**
     * Gets the order by clause for the query.
     * 
     * @param dto the data transfer object
     * @param builder the criteria builder
     * @param qRoot the root of the query
     * @return the list of order by clauses
     */
    protected List<Order> getOrderByClause(T dto, CriteriaBuilder builder, Root<T> qRoot) {
        LinkedHashMap<String, String> map = dto.orderBY();
        List<Order> orderBys = new ArrayList<>();
        map.forEach((key, value) -> {
            if ("asc".equals(value)) {
                orderBys.add(builder.asc(qRoot.get(key)));
            } else {
                orderBys.add(builder.desc(qRoot.get(key)));
            }
        });
        return orderBys;
    }
}
