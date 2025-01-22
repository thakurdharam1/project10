package com.rays.service;

import java.util.List;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.MarksheetDTO;

/**
 * Marksheet Service interface.
 * Suraj Sahu
 */
public interface MarksheetServiceInt extends BaseServiceInt<MarksheetDTO> {

    /**
     * Finds marksheet by name.
     * 
     * @param name the name of the student
     * @param context the user context
     * @return the found marksheet
     */
    MarksheetDTO findByName(String name, UserContext context);

    /**
     * Finds marksheet by Roll No.
     * 
     * @param rollNo the roll number of the student
     * @param context the user context
     * @return the found marksheet
     */
    MarksheetDTO findByRollNo(String rollNo, UserContext context);

    /**
     * Gets merit list of students.
     * 
     * @param context the user context
     * @return the list of top-performing marksheets
     */
    List<MarksheetDTO> getMeritList(UserContext context);
}
