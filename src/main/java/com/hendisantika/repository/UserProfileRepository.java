package com.hendisantika.repository;

import com.hendisantika.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/01/22
 * Time: 08.18
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
