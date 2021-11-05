package com.smart.advice;

import com.smart.dto.response.APIResponseDto;
import com.smart.enums.MessageEnum;
import com.smart.exceptions.DataAlreadyExistsException;
import com.smart.exceptions.DataNotFoundException;
import com.smart.exceptions.PasswordNotMatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUserNameNotFoundException(UsernameNotFoundException userNotFoundException){
        APIResponseDto<String> res=new APIResponseDto<>();
        res.setMessage(userNotFoundException.getMessage());
        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException dataNotFoundException){
        APIResponseDto<String> res=new APIResponseDto<>();
        res.setMessage(dataNotFoundException.getErrorMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAlreadyExistsException.class)
    public ResponseEntity<?> handleDataAlreadyExistsException(DataAlreadyExistsException dataAlreadyExistsException){
        APIResponseDto<String> res=new APIResponseDto<>();
        res.setMessage(dataAlreadyExistsException.getErrorMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<?> handlePasswordNotMatchException(PasswordNotMatchException passwordNotMatchException){
        APIResponseDto<String> res=new APIResponseDto<>();
        res.setMessage(passwordNotMatchException.getErrorMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<?> handleServletException(ServletException servletException){
        APIResponseDto<String> res=new APIResponseDto<>();
        res.setMessage(servletException.getMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    // Description-- Globally handling the Javax Validation Exception
    @Override
    protected @NonNull
    ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult=ex.getBindingResult();
        APIResponseDto<String> res=new APIResponseDto<>();
        if(bindingResult.hasFieldErrors("name")){
            res.setMessage(MessageEnum.SEND_PROPER_NAME.toString());
            return new ResponseEntity<>(res,HttpStatus.NOT_ACCEPTABLE);
        }
        if(bindingResult.hasFieldErrors("email")){
            res.setMessage(MessageEnum.EMAIL_NOT_VALID.toString());
            return new ResponseEntity<>(res,HttpStatus.NOT_ACCEPTABLE);
        }
        if(bindingResult.hasFieldErrors("about")){
            res.setMessage(MessageEnum.SEND_PROPER_ABOUT.toString());
            return new ResponseEntity<>(res,HttpStatus.NOT_ACCEPTABLE);
        }
        if(bindingResult.hasFieldErrors("password")){
            res.setMessage(MessageEnum.SEND_PROPER_PASSWORD.toString());
            return new ResponseEntity<>(res,HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(res,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception){
        APIResponseDto<String> res=new APIResponseDto<>();
        res.setMessage(exception.getMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
