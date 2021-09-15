package com.ecommerce.elasticSearch.testFiles;

import com.ecommerce.elasticSearch.document.Product;
import com.ecommerce.elasticSearch.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Map;

@Document(indexName = Indices.VERSION_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Version {

    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Object)
    private Map<String,String> versionAttributes;

    @Field(type = FieldType.Object)
    private com.ecommerce.elasticSearch.document.Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getVersionAttributes() {
        return versionAttributes;
    }

    public void setVersionAttributes(Map<String, String> versionAttributes) {
        this.versionAttributes = versionAttributes;
    }

    public com.ecommerce.elasticSearch.document.Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
