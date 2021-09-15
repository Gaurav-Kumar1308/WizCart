package com.ecommerce.productService.controller;


import com.ecommerce.productService.entity.Product;
import com.ecommerce.productService.service.ProductService;
import com.ecommerce.productService.service.impl.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product/db")
public class ProductController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private ProductService productService;

    @Autowired
    private NextSequenceService nextSequenceService;

    @GetMapping("/display")
    public String display(){
        return "Product Display";
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable(name="id") Long id){
        return productService.get(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        product.setId(nextSequenceService.getNextSequence("customSequenceProduct"));
        Product productSaved = productService.save(product);
        kafkaTemplate.send("new_product",product);
        return productSaved;
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        Product productUpdated = productService.update(product);
        kafkaTemplate.send("update_product",product);
        return productUpdated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        productService.delete(id);
    }
}
