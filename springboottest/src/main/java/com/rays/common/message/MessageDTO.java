package com.rays.common.message;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Email/SMS Message class. Message subject and body contain placeholders.
 * Placeholders are defined inside subject/body with {0}, {1}, {2}, etc.
 * 
 * Suraj Sahu
 */
@Entity
@Table(name = "ST_MESSAGE")
public class MessageDTO extends BaseDTO {

    public static final String ACTIVE = "Active";
    public static final String INACTIVE = "Inactive";
    public static final String EMAIL = "Email";
    public static final String SMS = "SMS";

    @Column(name = "CODE", length = 10, unique = true, nullable = false)
    private String code;

    @Column(name = "SUBJECT", length = 200, nullable = false)
    private String subject;

    @Column(name = "TYPE", length = 15)
    private String type = EMAIL;

    @Lob
    @Column(name = "BODY", nullable = false)
    private String body;

    @Column(name = "STATUS", length = 15)
    private String status = ACTIVE;

    @Column(name = "IS_HTML", length = 150)
    private String html = "Y";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Replaces message subject placeholders with parameters and returns the updated subject.
     * 
     * @param params the parameters to replace placeholders
     * @return the updated subject
     */
    public String getSubject(HashMap<String, String> params) {
        if (params == null) {
            return subject;
        }

        String text = this.subject;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            text = text.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return text;
    }

    /**
     * Replaces message body placeholders with parameters and returns the updated body.
     * 
     * @param params the parameters to replace placeholders
     * @return the updated body
     */
    public String getBody(HashMap<String, String> params) {
        if (params == null) {
            return body;
        }

        String text = this.body;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            text = text.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return text;
    }

    @Override
    public LinkedHashMap<String, String> orderBY() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("code", "asc");
        return map;
    }

    @Override
    public LinkedHashMap<String, Object> uniqueKeys() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("code", code);
        return map;
    }

    @Override
    public String getValue() {
        return code;
    }

    @Override
    public String getUniqueKey() {
        return null;
    }

    @Override
    public String getUniqueValue() {
        return null;
    }

    @Override
    public String getLabel() {
        return null;
    }
}
