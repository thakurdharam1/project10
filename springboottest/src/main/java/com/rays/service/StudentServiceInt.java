package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.StudentDTO;

/**
 * College Service interface.
 * Suraj Sahu 
 */

public interface StudentServiceInt extends BaseServiceInt<StudentDTO> {

	/**
	 * Finds a Student by email.
	 * 
	 * @param email the email of the student
	 * @param context the user context
	 * @return the student DTO
	 */
	public StudentDTO findByEmail(String email, UserContext context);

}