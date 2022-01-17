package com.hendisantika.common;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/01/22
 * Time: 08.11
 */
@Data
public class ApiResponse {
    private final boolean success;
    private final String message;
}
