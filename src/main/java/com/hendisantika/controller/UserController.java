package com.hendisantika.controller;

import com.hendisantika.dto.ResponseDto;
import com.hendisantika.dto.SignInDto;
import com.hendisantika.dto.SignInResponseDto;
import com.hendisantika.dto.SignupDto;
import com.hendisantika.entity.User;
import com.hendisantika.exception.AuthenticationFailException;
import com.hendisantika.exception.CustomException;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.service.AuthenticationService;
import com.hendisantika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/01/22
 * Time: 06.16
 */
@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

//    @PostMapping("/updateUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserUpdateDto userUpdateDto) {
//        authenticationService.authenticate(token);
//        return userService.updateUser(token, userUpdateDto);
//    }


//    @PostMapping("/createUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserCreateDto userCreateDto)
//            throws CustomException, AuthenticationFailException {
//        authenticationService.authenticate(token);
//        return userService.createUser(token, userCreateDto);
//    }
}
