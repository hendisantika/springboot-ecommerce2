package com.hendisantika.controller;

import com.hendisantika.dto.ProductDto;
import com.hendisantika.entity.WishList;
import com.hendisantika.service.AuthenticationService;
import com.hendisantika.service.ProductService;
import com.hendisantika.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/01/22
 * Time: 06.20
 */
@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("userId") Integer userId) {
        List<WishList> body = wishListService.readWishList(userId);
        List<ProductDto> products = new ArrayList<>();
        for (WishList wishList : body) {
            products.add(ProductService.getDtoFromProduct(wishList.getProduct()));
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
