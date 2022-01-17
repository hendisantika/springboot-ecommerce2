package com.hendisantika.dto;

import com.hendisantika.entity.Role;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/01/22
 * Time: 07.59
 */
@Data
public class UserCreateDto {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String password;
}
