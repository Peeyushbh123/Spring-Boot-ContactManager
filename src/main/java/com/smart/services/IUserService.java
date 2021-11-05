package com.smart.services;

import com.smart.dto.request.LoginRequestDto;
import com.smart.dto.request.UserRequestDto;
import com.smart.dto.response.JwtLoginResponseDto;
import com.smart.dto.response.UserResponseDto;
import com.smart.entities.User;
import com.smart.exceptions.DataAlreadyExistsException;
import com.smart.exceptions.DataNotFoundException;
import com.smart.exceptions.PasswordNotMatchException;

import java.util.List;

public interface IUserService {
    public List<UserResponseDto> getAllUsers() throws DataNotFoundException;

    public UserResponseDto signUp(UserRequestDto userRequestDto) throws DataAlreadyExistsException, PasswordNotMatchException;

    public JwtLoginResponseDto signIn(LoginRequestDto loginRequestDto) throws DataNotFoundException;

    public UserResponseDto deleteAccount(int id,String password) throws DataNotFoundException;
}
