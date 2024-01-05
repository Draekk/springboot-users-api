package com.draekk.springboot.springbootusersapi.models.dtos;

public class UserResponseDto {

    private UserDto user;
    private ResponseDto response;

    public ResponseDto getResponse() {
        return response;
    }

    public void setResponse(ResponseDto response) {
        this.response = response;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
