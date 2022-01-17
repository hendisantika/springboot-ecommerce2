package com.hendisantika.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/01/22
 * Time: 08.30
 */
public class CustomException extends IllegalArgumentException {
    public CustomException(String msg) {
        super(msg);
    }
}
