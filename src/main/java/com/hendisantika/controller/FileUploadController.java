package com.hendisantika.controller;

import com.hendisantika.service.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/01/22
 * Time: 06.10
 */
@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {

    @Autowired
    private FileStoreService fileStoreService;

}
