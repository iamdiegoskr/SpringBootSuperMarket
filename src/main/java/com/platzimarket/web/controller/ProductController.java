package com.platzimarket.web.controller;

import com.platzimarket.domain.models.Product;
import com.platzimarket.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping()
    @ApiOperation("get all supermarket products")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    @ApiOperation("get product by id from product")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404, message = "Product is not found")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product",required = true, example = "7")
                                                  @PathVariable() int productId){
        return service.getProduct(productId)
                .map(product-> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    @ApiOperation("ger products by category")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable() int categoryId){
        return  service.getByCategory(categoryId)
                .map(products-> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation("Create a new product from supermarket")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
    }

    @ApiOperation("Delete a product by id")
    @DeleteMapping("/{id}")
    public ResponseEntity removeProduct(@PathVariable() int id){
        if(service.removeProduct(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
