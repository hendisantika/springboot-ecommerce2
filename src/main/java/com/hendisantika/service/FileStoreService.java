package com.hendisantika.service;

import com.hendisantika.config.StorageProperties;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/01/22
 * Time: 08.47
 */
@Service
public class FileStoreService {

    private final StorageProperties properties = new StorageProperties();
    private final Path rootLocation = Paths.get(properties.getLocation());

}
