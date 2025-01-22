package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDTO;

/**
 * College Service interface.
 * Suraj Sahu
 */
public interface CollegeServiceInt extends BaseServiceInt<CollegeDTO> {

    /**
     * Finds a college by name.
     * 
     * @param name the name of the college
     * @param context the context of the user making the request
     * @return the found CollegeDTO
     */
    CollegeDTO findByName(String name, UserContext context);
}
