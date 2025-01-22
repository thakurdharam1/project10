package com.rays.common;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Base DAO interface for common data operations.
 *
 * @param <T> The type of the DTO that extends BaseDTO
 */
public interface BaseDAOInt<T extends BaseDTO> {

    /**
     * Adds a record.
     *
     * @param dto The DTO to be added
     * @param userContext The context of the user performing the operation
     * @return The ID of the added record
     */
    long add(T dto, UserContext userContext);

    /**
     * Updates a record.
     *
     * @param dto The DTO to be updated
     * @param userContext The context of the user performing the operation
     */
    void update(T dto, UserContext userContext);

    /**
     * Deletes a record.
     *
     * @param dto The DTO to be deleted
     * @param userContext The context of the user performing the operation
     */
    void delete(T dto, UserContext userContext);

    /**
     * Finds a record by primary key.
     *
     * @param pk The primary key of the record
     * @param userContext The context of the user performing the operation
     * @return The found record, or null if not found
     */
    T findByPK(long pk, UserContext userContext);

    /**
     * Finds a record by unique key.
     *
     * @param attribute The name of the attribute
     * @param val The value of the attribute
     * @param userContext The context of the user performing the operation
     * @return The found record, or null if not found
     */
    T findByUniqueKey(String attribute, Object val, UserContext userContext);

    /**
     * Searches for records with pagination.
     *
     * @param dto The DTO used for searching
     * @param pageNo The page number for pagination
     * @param pageSize The number of records per page
     * @param userContext The context of the user performing the operation
     * @return A list of records matching the search criteria
     */
    List<T> search(T dto, int pageNo, int pageSize, UserContext userContext);

    /**
     * Searches for records.
     *
     * @param dto The DTO used for searching
     * @param userContext The context of the user performing the operation
     * @return A list of records matching the search criteria
     */
    List<T> search(T dto, UserContext userContext);

    /**
     * Runs an HQL query.
     *
     * @param hql The HQL query string
     * @param userContext The context of the user performing the operation
     * @return A list of results from the query
     */
    List<?> runHQL(String hql, UserContext userContext);

    /**
     * Sets the EntityManager.
     *
     * @param entityManager The EntityManager to set
     */
    void setEntityManager(EntityManager entityManager);
}
