package com.example.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * 10.批量删除
 */
public class ES_Doc_Delete_Batch {
    public static void main(String[] args) throws Exception {

        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //创建批量删除请求对象
        BulkRequest request = new BulkRequest();

        request.add(new DeleteRequest().index("user").id("1001"));
        request.add(new DeleteRequest().index("user").id("1002"));
        request.add(new DeleteRequest().index("user").id("1003"));
        request.add(new DeleteRequest().index("user").id("1004"));
        request.add(new DeleteRequest().index("user").id("1005"));
        request.add(new DeleteRequest().index("user").id("1006"));
        request.add(new DeleteRequest().index("user").id("1007"));
        request.add(new DeleteRequest().index("user").id("1008"));
        request.add(new DeleteRequest().index("user").id("1009"));

        //客户端发送请求，获取响应对象
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println(response.getTook());
        System.out.println(response.getItems());
        // 关闭ES客户端
        esClient.close();
    }
}
