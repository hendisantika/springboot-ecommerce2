package com.hendisantika.service;

import com.hendisantika.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
