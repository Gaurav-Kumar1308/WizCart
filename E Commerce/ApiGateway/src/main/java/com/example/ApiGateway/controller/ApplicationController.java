package com.example.ApiGateway.controller;

import com.example.ApiGateway.dto.*;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ApplicationController {
    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/addProduct")
    public ProductResponseDTO addProduct(@RequestBody AddProductDTO addProductDTO){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(addProductDTO,productDTO);

        InventoryDTO inventoryDTO = new InventoryDTO();
        BeanUtils.copyProperties(addProductDTO, inventoryDTO);

        HttpEntity<ProductDTO> request = new HttpEntity<>(productDTO);
        ProductDTO savedProductDTO = restTemplate.postForObject("http://localhost:8070/product/db",request,ProductDTO.class);

        System.out.println(savedProductDTO);
        inventoryDTO.setProductId(savedProductDTO.getId());

        HttpEntity<InventoryDTO> inventoryRequest = new HttpEntity<>(inventoryDTO);
        InventoryDTO savedInventoryDTO = restTemplate.postForObject("http://localhost:8070/inventory/db",inventoryRequest,InventoryDTO.class);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        BeanUtils.copyProperties(addProductDTO,productResponseDTO);

        productResponseDTO.setProductId(savedProductDTO.getId());
        productResponseDTO.setRating(0);
        HttpEntity<ProductResponseDTO> elasticRequest = new HttpEntity<>(productResponseDTO);
        ProductResponseDTO productResponseDTO1 = restTemplate.postForObject("http://localhost:8070/es",elasticRequest,ProductResponseDTO.class);
        System.out.println(productResponseDTO1);
        return productResponseDTO1;
    }

    @PostMapping("/updateProduct")
    public void updateProduct(@RequestBody UpdateProductDTO updateProductDTO){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(updateProductDTO,productDTO);

        HttpEntity<ProductDTO> request = new HttpEntity<>(productDTO);
        restTemplate.put("http://localhost:8070/product/db",request);

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setProductId(productDTO.getId());

        HttpEntity<InventoryDTO> inventoryRequest = new HttpEntity<>(inventoryDTO);
        restTemplate.put("http://localhost:8070/inventory/db",inventoryRequest);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        BeanUtils.copyProperties(updateProductDTO,productResponseDTO);

        HttpEntity<ProductResponseDTO> elasticRequest = new HttpEntity<>(productResponseDTO);
        restTemplate.put("http://localhost:8070/es",elasticRequest);

    }

    @PostMapping("/user/register")
    public String userLogin(@RequestBody RegisterDTO registerDTO){
        HttpEntity<RegisterDTO> request = new HttpEntity<>(registerDTO);
        RegisterDTO userSaved = restTemplate.postForObject("http://localhost:8070/auth/user/db",registerDTO,RegisterDTO.class);
        System.out.println(userSaved);

        if(userSaved == null) return "Email Already exists";
        else return "True";
    }

    @PostMapping("/merchant/register")
    public String userRegister(@RequestBody RegisterDTO registerDTO){
        HttpEntity<RegisterDTO> request = new HttpEntity<>(registerDTO);
        RegisterDTO merchantSaved = restTemplate.postForObject("http://localhost:8070/auth/merchant/db",registerDTO,RegisterDTO.class);
        System.out.println(merchantSaved);

        if(merchantSaved == null) return "false";
        else return "True";
    }

    @PostMapping("/user/login")
    public LoginResponseDTO userLogin(@RequestBody LoginDTO loginDTO){
        HttpEntity<LoginDTO> request = new HttpEntity<>(loginDTO);
        System.out.println("INCOMING REQUEST "+loginDTO);
        LoginResponseDTO loginResponseDTO = restTemplate.postForObject("http://localhost:8070/auth/user/db/validate",loginDTO,LoginResponseDTO.class);
        return loginResponseDTO;
    }

    @PostMapping("/merchant/login")
    public LoginResponseDTO merchantLogin(@RequestBody LoginDTO loginDTO){
        HttpEntity<LoginDTO> request = new HttpEntity<>(loginDTO);
        LoginResponseDTO loginResponseDTO = restTemplate.postForObject("http://localhost:8070/auth/merchant/db/validate",loginDTO,LoginResponseDTO.class);
        return loginResponseDTO;
    }

    @PostMapping("/search")
    public List<ProductResponseDTO> search(@RequestBody SearchDTO searchDTO){
        HttpEntity<SearchDTO> request = new HttpEntity<>(searchDTO);
        List<ProductResponseDTO> productResponseDTOS = restTemplate.getForObject("http://localhost:8070/es/search",List.class);
        return productResponseDTOS;
    }

    @PostMapping("/addToCart")
    public void addToCart(@RequestBody CartDTO cartDTO){
        HttpEntity<CartDTO> request = new HttpEntity<>(cartDTO);
        CartDTO cartDTO1 = restTemplate.postForObject("http://localhost:8070/order/cart/db",cartDTO,CartDTO.class);
        System.out.println(cartDTO1);
    }

    @PostMapping("/bookOrder")
    public void bookOrder(@RequestBody OrderHistoryDTO orderHistoryDTO){
        HttpEntity<OrderHistoryDTO> request = new HttpEntity<>(orderHistoryDTO);
        OrderHistoryDTO dto = restTemplate.postForObject("http://localhost:8070/order/order/db/create",orderHistoryDTO,OrderHistoryDTO.class);
        System.out.println(orderHistoryDTO);
    }
    @PostMapping("/cartView")
    public void cartView(@RequestBody )


}
