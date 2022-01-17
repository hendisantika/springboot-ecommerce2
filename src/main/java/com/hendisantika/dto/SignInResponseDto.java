package com.hendisantika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/01/22
 * Time: 07.57
 */
@Data
@AllArgsConstructor
public class SignInResponseDto {
    private String status;
    private String token;
}
