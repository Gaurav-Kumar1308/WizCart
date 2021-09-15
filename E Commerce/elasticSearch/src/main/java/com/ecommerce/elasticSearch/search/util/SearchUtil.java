package com.ecommerce.elasticSearch.search.util;

import com.ecommerce.elasticSearch.search.SearchDTO;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class SearchUtil {
    private SearchUtil(){};

    public static SearchRequest buildSearchRequest(String indexName, SearchDTO dto){
        try {
            SearchSourceBuilder builder = new SearchSourceBuilder().postFilter(getQueryBuilder(dto));
            SearchRequest request = new SearchRequest(indexName);
            request.source(builder);

            return request;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static QueryBuilder getQueryBuilder(SearchDTO dto){
        if(dto==null) return null;

        List<String> fields = dto.getFields();

        if(CollectionUtils.isEmpty(fields)){
            return null;
        }

        if(fields.size()>1){
            System.out.println(dto.getSearchTerm());
            MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(dto.getSearchTerm())
                    .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                    .operator(Operator.AND);
            fields.forEach(multiMatchQueryBuilder::field);
            return multiMatchQueryBuilder;
        }

        return fields.stream().findFirst().map(field->QueryBuilders.matchQuery(field,dto.getSearchTerm()).operator(Operator.AND)).orElse(null);
    }

}
