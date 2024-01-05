package com.draekk.springboot.springbootusersapi.models.dtos;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {
    
    private String method;
    private Integer status;
    private String message;

    public ResponseDto(String method, Integer status) {
        this.method = method;
        this.status = status;
        this.message = HttpStatus.valueOf(status).getReasonPhrase();
    }
}
