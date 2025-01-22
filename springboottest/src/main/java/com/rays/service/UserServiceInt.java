package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;

/**
 * User Service interface for user-related operations.
 *
 * Suraj Sahu
 */
public interface UserServiceInt extends BaseServiceInt<UserDTO> {

    /**
     * Finds a user by login ID.
     *
     * @param loginId The login ID of the user
     * @param userContext The context of the user making the request
     * @return The user with the specified login ID, or null if not found
     */
    UserDTO findByLoginId(String loginId, UserContext userContext);

    /**
     * Finds a user by email.
     *
     * @param email The email of the user
     * @param userContext The context of the user making the request
     * @return The user with the specified email, or null if not found
     */
    UserDTO findByEmail(String email, UserContext userContext);

    /**
     * Authenticates a user based on login ID and password.
     *
     * @param loginId The login ID of the user
     * @param password The password of the user
     * @return The authenticated user, or null if authentication fails
     */
    UserDTO authenticate(String loginId, String password);

    /**
     * Changes the password for a user.
     *
     * @param loginId The login ID of the user
     * @param oldPassword The current password of the user
     * @param newPassword The new password to set
     * @param userContext The context of the user making the request
     * @return The updated user, or null if the password change fails
     */
    UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext);

    /**
     * Handles forgotten password requests.
     *
     * @param loginId The login ID of the user who forgot their password
     * @return The user with the specified login ID, or null if not found
     */
    UserDTO forgotPassword(String loginId);

    /**
     * Registers a new user.
     *
     * @param dto The user data transfer object containing user information
     * @return The registered user
     */
    UserDTO register(UserDTO dto);
}
