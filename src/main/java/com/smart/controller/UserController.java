package com.smart.controller;

import com.smart.dto.request.LoginRequestDto;
import com.smart.dto.request.UserRequestDto;
import com.smart.dto.response.APIResponseDto;
import com.smart.dto.response.JwtLoginResponseDto;
import com.smart.dto.response.UserResponseDto;
import com.smart.entities.User;
import com.smart.enums.MessageEnum;
import com.smart.exceptions.DataAlreadyExistsException;
import com.smart.exceptions.DataNotFoundException;
import com.smart.exceptions.PasswordNotMatchException;
import com.smart.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // Desc. Controller for getting All users.
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() throws DataNotFoundException {
        APIResponseDto<List<UserResponseDto>> response=new APIResponseDto<>();
        List<UserResponseDto> list=userService.getAllUsers();
        response.setData(list);
        response.setMessage(MessageEnum.FOUND_ALL_USERS.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Desc. Controller for signing up.
    @PostMapping("/register")
    public ResponseEntity<?> createAccount(
            @Valid @RequestBody UserRequestDto userRequestDto
    ) throws DataAlreadyExistsException, PasswordNotMatchException {
        APIResponseDto<UserResponseDto> response=new APIResponseDto<>();
        UserResponseDto userResponseDto=userService.signUp(userRequestDto);
        response.setData(userResponseDto);
        response.setMessage(MessageEnum.SUCCESS_CREATE_ACCOUNT.toString());
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //Desc. Controller for signing in.
    @PutMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequestDto loginRequestDto
            ) throws DataNotFoundException{
        APIResponseDto<JwtLoginResponseDto> response=new APIResponseDto<>();
        JwtLoginResponseDto jwtLoginResponseDto=userService.signIn(loginRequestDto);
        response.setData(jwtLoginResponseDto);
        response.setMessage(MessageEnum.LOGGED_IN.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

//    @DeleteMapping("/deleteaccount/{id}")
//    public ResponseEntity<?> deleteAccount(
//            @PathVariable("id") int id, @RequestBody Map<String,String> payLoad
//    ) throws DataNotFoundException{
//        APIResponseDto<UserResponseDto> response=new APIResponseDto<>();
//        UserResponseDto userResponseDto=userService.deleteAccount(id,payLoad.get("password"));
//        response.setData(userResponseDto);
//        response.setMessage(MessageEnum.SUCCESS_DELETE.toString());
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }

}
