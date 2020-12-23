package com.tuacy.es.high.level.rest.client.api.document;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2020/12/22 19:44.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentApiTest {

    private DocumentApi documentApi;

    @Autowired
    public void setDocumentApi(DocumentApi documentApi) {
        this.documentApi = documentApi;
    }

    @Test
    public void indexApiTest() {
        documentApi.indexApi();
    }

    @Test
    public void getApiTest() {
        documentApi.getApi();
    }
}
