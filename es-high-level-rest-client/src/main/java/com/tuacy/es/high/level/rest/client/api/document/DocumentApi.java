package com.tuacy.es.high.level.rest.client.api.document;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文档API
 * elasticsearch document 对应api
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-supported-apis.html
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/12/22 19:39.
 */
@Service
@Slf4j
public class DocumentApi {

    private RestHighLevelClient restHighLevelClient;

    @Autowired
    public void setRestHighLevelClient(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    /**
     * 索引请求API
     */
    public void indexApi() {
        IndexRequest request = new IndexRequest("posts");
        /*
        文档id
         */
        request.id("1");
        /*
        文档源, 有多种方式提供文档源
         */
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);

        /*
        可选参数
         */
        // 指定路由值，同一个路由值的文档会放在同一个分片上
        request.routing("routing");
        //
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");


        try {
            IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            final String index = indexResponse.getIndex();
            final String id = indexResponse.getId();
            final long version = indexResponse.getVersion();
            System.out.println("aaaaaaaaaaaa");
        } catch (Exception ex) {

        }
    }

    public void getApi() {
        GetRequest getRequest = new GetRequest(
                "posts",
                "1");
        try {
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            System.out.println("aaaaaaaaaaaa");
        } catch (Exception ex) {
        }
    }


}
