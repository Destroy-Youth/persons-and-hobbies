package com.destroyyouth.personsandhobbies.commons.dtos;

import java.io.Serializable;

public class ErrorTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6977271152623032005L;

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
