package com.draekk.springboot.springbootusersapi.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

    private String message;
    private String exception;
    private Integer status;
    private Date date;
}
