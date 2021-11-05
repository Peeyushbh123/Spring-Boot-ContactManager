package com.smart.services;

import com.smart.dao.IUserDao;
import com.smart.dto.request.LoginRequestDto;
import com.smart.dto.request.UserRequestDto;
import com.smart.dto.response.JwtLoginResponseDto;
import com.smart.dto.response.UserResponseDto;
import com.smart.entities.User;
import com.smart.enums.MessageEnum;
import com.smart.exceptions.DataAlreadyExistsException;
import com.smart.exceptions.DataNotFoundException;
import com.smart.exceptions.PasswordNotMatchException;
import com.smart.helper.JwtUtil;
import com.smart.helper.Validators;
import com.smart.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private IUserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validators validator;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserService;

    @Autowired
    private JwtUtil util;

    //Desc. Getting All Users.
    @Override
    public List<UserResponseDto> getAllUsers() throws DataNotFoundException{
        List<UserResponseDto> list=new ArrayList<>();
        List<User> userList=userDao.findAllUsers();
        if(CollectionUtils.isEmpty(userList)){
            throw new DataNotFoundException(MessageEnum.DATA_NOT_FOUND.toString());
        }
        for(User user:userList){
            UserResponseDto userResponseDto=new UserResponseDto();
            userResponseDto.convertToUserResponse(user);
            list.add(userResponseDto);
        }

        return list;
    }

    // Desc. Signing Up the User
    @Override
    public UserResponseDto signUp(
            UserRequestDto userRequestDto) throws DataAlreadyExistsException,PasswordNotMatchException{
        Optional<User> userOp=userRepository.findByEmail(userRequestDto.getEmail());
        if(userOp.isPresent()){
            throw new DataAlreadyExistsException(MessageEnum.EMAIL_ALREADY_USED.toString());
        }
        if(!validator.is_Valid_Password(userRequestDto.getPassWord())){
            throw new PasswordNotMatchException(MessageEnum.PASSWORD_STRENGTH_WEAK.toString());
        }
        String encodedPassword=bCryptPasswordEncoder.encode(userRequestDto.getPassWord());
        User user=new User();
        user.setAbout(userRequestDto.getAbout());
        user.setEmail(userRequestDto.getEmail());
        user.setName(userRequestDto.getName());
        user.setPass(encodedPassword);
        user.setRole("USER");
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.convertToUserResponse(userDao.addUser(user));

        return userResponseDto;
    }

    @Override
    public JwtLoginResponseDto signIn(LoginRequestDto loginRequestDto) throws DataNotFoundException{

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDto.getEmail(),loginRequestDto.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw new DataNotFoundException(MessageEnum.BAD_CREDENTIALS.toString());
        }

        final UserDetails userDetails=customUserService.loadUserByUsername(loginRequestDto.getEmail());
        final String token= util.generateToken(userDetails);
        JwtLoginResponseDto responseDto=new JwtLoginResponseDto();
        responseDto.setToken(token);

        return responseDto;
    }

    @Override
    public UserResponseDto deleteAccount(int id,String password) throws DataNotFoundException {
        Optional<User> userOp=userDao.findUserById(id);
        if(!userOp.isPresent()){
            throw new DataNotFoundException(MessageEnum.DATA_NOT_FOUND.toString());
        }
        userDao.deleteUserById(id);
        UserResponseDto responseDto=new UserResponseDto();
        responseDto.convertToUserResponse(userOp.get());
        return responseDto;
    }
}
