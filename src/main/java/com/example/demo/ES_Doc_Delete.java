package com.example.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * 8.删除文档
 */
public class ES_Doc_Delete {
    public static void main(String[] args) throws Exception {

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //1.创建请求对象
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");
        //2.客户端发送请求，获取响应对象
        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);
        //3.打印信息
        System.out.println(response.toString());
        // 关闭ES客户端
        esClient.close();
    }
}
