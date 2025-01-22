package com.rays.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.exception.DatabaseException;
import com.rays.exception.DuplicateRecordException;

/**
 * Suraj Sahu
 * 
 * @param <T> the type of the DTO
 * @param <D> the type of the DAO
 */
public abstract class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> {

    private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    protected D baseDao;

    /**
     * Finds a record by ID.
     * 
     * @param id the ID of the record
     * @param userContext the user context
     * @return the found record
     */
    @Transactional(readOnly = true)
    public T findById(long id, UserContext userContext) {
        return baseDao.findByPK(id, userContext);
    }

    /**
     * Finds a record by unique key.
     * 
     * @param att the attribute name
     * @param val the attribute value
     * @param userContext the user context
     * @return the found record
     */
    @Transactional(readOnly = true)
    public T findByUniqueKey(String att, String val, UserContext userContext) {
        return baseDao.findByUniqueKey(att, val, userContext);
    }

    /**
     * Searches records with pagination.
     * 
     * @param dto the search criteria
     * @param pageNo the page number
     * @param pageSize the page size
     * @param userContext the user context
     * @return the list of records
     */
    @Transactional(readOnly = true)
    public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
        return baseDao.search(dto, pageNo, pageSize, userContext);
    }

    /**
     * Searches records.
     * 
     * @param dto the search criteria
     * @param userContext the user context
     * @return the list of records
     */
    @Transactional(readOnly = true)
    public List<T> search(T dto, UserContext userContext) {
        return baseDao.search(dto, userContext);
    }

    /**
     * Adds a new record.
     * 
     * @param dto the record to add
     * @param userContext the user context
     * @return the ID of the added record
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(readOnly = false)
    public long add(T dto, UserContext userContext) throws DuplicateRecordException {
        return baseDao.add(dto, userContext);
    }

    /**
     * Updates an existing record.
     * 
     * @param dto the record to update
     * @param userContext the user context
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T dto, UserContext userContext) throws DuplicateRecordException {
        baseDao.update(dto, userContext);
    }

    /**
     * Saves a record (add or update).
     * 
     * @param dto the record to save
     * @param userContext the user context
     * @return the ID of the saved record
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public long save(T dto, UserContext userContext) throws DuplicateRecordException {
        Long id = dto.getId();
        if (id != null && id > 0) {
            update(dto, userContext);
        } else {
            id = add(dto, userContext);
        }
        return id;
    }

    /**
     * Deletes a record by ID.
     * 
     * @param id the ID of the record
     * @param userContext the user context
     * @return the deleted record
     * @throws DatabaseException if the record is not found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public T delete(long id, UserContext userContext) {
        log.debug("Base Service delete Start");
        T dto = findById(id, userContext);
        if (dto == null) {
            throw new DatabaseException("Record not found");
        }
        baseDao.delete(dto, userContext);
        log.debug("Base Service delete End");
        return dto;
    }
}
