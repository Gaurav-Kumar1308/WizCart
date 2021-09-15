package com.ecommerce.elasticSearch.controller;


import com.ecommerce.elasticSearch.document.Product;
import com.ecommerce.elasticSearch.search.SearchDTO;
import com.ecommerce.elasticSearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/es")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/display")
    public String display(){
        return "In Elastic Search";
    }


    @GetMapping("/{id}")
    public Product get(@PathVariable(name = "id") Long id){
        return productService.get(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        productService.delete(id);
    }

    @PostMapping("/all")
    public void saveAll(@RequestBody List<Product> productList){
        productService.saveAll(productList);
    }

    @PostMapping("/search")
    public List<Product> search(@RequestBody SearchDTO searchDTO){

        List<String> fields = new ArrayList<>();
        fields.add("productName");
        fields.add("attributes");
        fields.add("category");
        fields.add("price");
        fields.add("description");
        searchDTO.setFields(fields);
        System.out.println(searchDTO);
        return productService.search(searchDTO);
    }

    @GetMapping("/getMerchant/{id}")
    public List<Product> findByMerchantId(@PathVariable(name = "id") Long merchantId){
        return productService.findByMerchantId(merchantId);
    }
}
