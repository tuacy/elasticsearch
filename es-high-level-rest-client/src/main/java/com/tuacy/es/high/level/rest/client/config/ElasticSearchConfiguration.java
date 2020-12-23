package com.tuacy.es.high.level.rest.client.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/12/22 19:29.
 */
@Configuration
@Slf4j
public class ElasticSearchConfiguration extends AbstractFactoryBean<RestHighLevelClient> {

    private RestHighLevelClient restHighLevelClient;

    @Override
    public void destroy() throws Exception {
        // RestHighLevelClient销毁
        if (restHighLevelClient != null) {
            restHighLevelClient.close();
        }
    }

    @Override
    public Class<?> getObjectType() {
        return RestHighLevelClient.class;
    }

    @Override
    protected RestHighLevelClient createInstance() {
        try {
            // 如果有多个节点，构建多个HttpHost
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
            );
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return restHighLevelClient;
    }
}
