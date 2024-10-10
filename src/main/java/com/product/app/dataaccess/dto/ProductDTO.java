package com.product.app.dataaccess.dto;

import com.product.app.dataaccess.entities.InventoryStatus;
import com.product.app.validation.ValidInventoryStatus;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductDTO {

    private Integer id;
    @NotNull(message="code should not be null")
    private String code;
    @NotBlank(message = "name should not be null")
    private String name;
    private String description;
    private String image;
    @NotBlank(message = "category should not be null")
    private String category;
    @NotNull(message = "price should not be null")
    private Integer price;
    @NotNull(message = "quantity should not be null")
    private Integer quantity;
    private String internalReference;
    private Integer shellId;
    @ValidInventoryStatus
    InventoryStatus inventoryStatus;
    private Integer rating;
    private Date createdAt;
    private Date updatedAt;
}
