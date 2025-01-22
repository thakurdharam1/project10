package com.rays.common.message;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;

/**
 * Message Service interface.
 * Suraj Sahu
 */
public interface MessageServiceInt extends BaseServiceInt<MessageDTO> {

    /**
     * Finds a message by title.
     * 
     * @param title the title of the message
     * @param userContext the user context
     * @return the message DTO
     */
    MessageDTO findByTitle(String title, UserContext userContext);

    /**
     * Finds a message by code.
     * 
     * @param code the code of the message
     * @param userContext the user context
     * @return the message DTO
     */
    MessageDTO findByCode(String code, UserContext userContext);
}
