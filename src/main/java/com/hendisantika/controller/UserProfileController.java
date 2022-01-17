package com.hendisantika.controller;

import com.hendisantika.entity.UserProfile;
import com.hendisantika.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/01/22
 * Time: 06.18
 */
@RestController
@RequestMapping("/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/")
    public ResponseEntity<List<UserProfile>> getUsers() {
        List<UserProfile> dtos = userProfileService.listProfiles();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
