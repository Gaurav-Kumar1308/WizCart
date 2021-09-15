package com.ecommerce.productService.service.impl;


import com.ecommerce.productService.entity.CustomSequenceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


@Service

public class NextSequenceService {

    @Autowired
    private MongoOperations mongoOperations;

    public Long getNextSequence(String seqName){
        CustomSequenceProduct counter = mongoOperations.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                CustomSequenceProduct.class);
        return Long.valueOf(counter.getSeq());
    }
}
