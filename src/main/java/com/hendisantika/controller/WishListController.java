package com.hendisantika.controller;

import com.hendisantika.common.ApiResponse;
import com.hendisantika.dto.ProductDto;
import com.hendisantika.entity.Product;
import com.hendisantika.entity.WishList;
import com.hendisantika.service.AuthenticationService;
import com.hendisantika.service.ProductService;
import com.hendisantika.service.WishListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Tag(name = "Wish List", description = "Endpoints for managing Wish List")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/{userId}")
    @Operation(
            summary = "Get All Users WishList",
            description = "Get All Users WishList.",
            tags = {"Wish List"})
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            ArrayList.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("userId") Integer userId) {
        List<WishList> body = wishListService.readWishList(userId);
        List<ProductDto> products = new ArrayList<>();
        for (WishList wishList : body) {
            products.add(ProductService.getDtoFromProduct(wishList.getProduct()));
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add")
    @Operation(
            summary = "Add New Wish List",
            description = "Add New Wish List.",
            tags = {"Wish List"})
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            ApiResponse.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public ResponseEntity<ApiResponse> addWishList(@RequestBody Product product, @RequestParam("token") String token) {
        int userId = authenticationService.getUser(token).getId();
        WishList wishList = new WishList(userId, product.getId());
        wishListService.createWishlist(wishList);
        return new ResponseEntity<>(new ApiResponse(true, "Add to wishlist"), HttpStatus.CREATED);

    }
}
