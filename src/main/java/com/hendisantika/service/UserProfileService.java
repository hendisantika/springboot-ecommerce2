package com.hendisantika.service;

import com.hendisantika.entity.UserProfile;
import com.hendisantika.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/01/22
 * Time: 06.00
 */
@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userRepo;

    public void addProfile(UserProfile userProfile) {
        userRepo.save(userProfile);
    }

    public List<UserProfile> listProfiles() {
        return userRepo.findAll();
    }
}
