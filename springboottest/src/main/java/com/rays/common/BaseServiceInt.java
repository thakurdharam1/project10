package com.rays.common;

import java.util.List;

import com.rays.exception.DuplicateRecordException;

/**
 * Role Service interface.
 * Suraj Sahu
 */

public interface BaseServiceInt<T extends BaseDTO> {

	/**
	 * Adds a Role.
	 * 
	 * @param dto
	 * @param userContext the user context
	 * @return
	 * @throws DuplicateRecordException
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Updates a Role.
	 * 
	 * @param dto
	 * @param userContext the user context
	 * @throws DuplicateRecordException
	 */
	public void update(T dto, UserContext userContext);

	
	public long save(T dto, UserContext userContext);

	/**
	 * Deletes a Role
	 * 
	 * @param id
	 * @param userContext the user context
	 */
	public T delete(long id, UserContext userContext);

	/**
	 * Finds a Role by ID
	 * 
	 * @param id
	 * @param userContext the user context
	 * @return
	 */
	public T findById(long id, UserContext userContext);


	public T findByUniqueKey(String att, String val, UserContext userContext);
	
	/**
	 * Searches Roles with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @param userContext the user context
	 * @return
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	/**
	 * Searches Roles
	 * 
	 * @param dto
	 * @param userContext the user context
	 * @return
	 */
	public List search(T dto, UserContext userContext);



}