package com.juniper.onlinesavdo.controller;

import com.juniper.onlinesavdo.payload.request.ProductReqDto;
import com.juniper.onlinesavdo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("Productlarni saqlash")
    @PostMapping("/admin/product/save")
    public ResponseEntity saveProducts(@RequestBody ProductReqDto productReqDto)
    {
        return ResponseEntity.ok(productService.saveProduct(productReqDto));
    }

    @ApiOperation("Barcha productlarni olish")
    @GetMapping("/user/getAllProduct")
    public ResponseEntity getAllProducts()
    {
        return ResponseEntity.ok(productService.getAllProduct());
    }
}
