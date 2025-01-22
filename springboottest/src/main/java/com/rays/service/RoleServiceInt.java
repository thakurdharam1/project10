package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;

/**
 * Role Service interface for role-related operations.
 * 
 * Suraj Sahu
 */
public interface RoleServiceInt extends BaseServiceInt<RoleDTO> {

    /**
     * Finds a role by its name.
     * 
     * @param name The name of the role
     * @param userContext The context of the user making the request
     * @return The role with the specified name, or null if not found
     */
    RoleDTO findByName(String name, UserContext userContext);
}
