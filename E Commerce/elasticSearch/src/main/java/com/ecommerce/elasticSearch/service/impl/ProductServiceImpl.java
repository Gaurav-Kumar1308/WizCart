package com.ecommerce.elasticSearch.service.impl;

import com.ecommerce.elasticSearch.document.Product;
import com.ecommerce.elasticSearch.helper.Indices;
import com.ecommerce.elasticSearch.repository.ProductRepository;
import com.ecommerce.elasticSearch.search.SearchDTO;
import com.ecommerce.elasticSearch.search.util.SearchUtil;
import com.ecommerce.elasticSearch.service.ProductService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> search(SearchDTO searchDTO){
        SearchRequest request = SearchUtil.buildSearchRequest(Indices.PRODUCT_INDEX,searchDTO);
        ObjectMapper mapper = new ObjectMapper();
        if(request==null){
            System.out.println("Failed to build search request");
            return Collections.emptyList();
        }

        try {
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);

            SearchHit[] searchHits = response.getHits().getHits();
            System.out.println("Search Hits ----> "+searchHits.length);
            List<Product> productList = new ArrayList<>(searchHits.length);
            for(SearchHit hit: searchHits){
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                productList.add(mapper.readValue(hit.getSourceAsString(),Product.class));
            }
            return productList;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void saveAll(@RequestBody List<Product> productList){
        productRepository.saveAll(productList);
    }
    @Override
    public List<Product> findByMerchantId(Long merchantId){
        return productRepository.findByMerchantId(merchantId);
    }


}
