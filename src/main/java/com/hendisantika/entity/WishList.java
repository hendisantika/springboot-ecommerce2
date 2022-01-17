package com.hendisantika.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/01/22
 * Time: 08.09
 */
@Entity
@Table(name = "wishlist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private @NotBlank Integer userId;

    @Column(name = "product_id")
    private @NotBlank Long productId;


    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public WishList(Integer userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
        this.createdDate = new Date();
    }

}
