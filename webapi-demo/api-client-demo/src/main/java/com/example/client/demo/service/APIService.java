package com.example.client.demo.service;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

@Service
@Slf4j
public class APIService {

    @Getter
    @Setter
    private HttpHeaders headers;

/*    public <T> T getObject(String url, Map<String, Object> params) {

        RestTemplate restTemplate = new RestTemplate();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T data = restTemplate.getForObject(url, entityClass, params);
        return data;
    }

    public <T> T getObject(String url) {
        return getObject(url, null);
    }*/

    public String get(String url) {
        return get(url,null);
    }

    public String get(String url, Map<String, Object> params){

        try {

            RestTemplate restTemplate = new RestTemplate();

            //发起get请求
            //"http://127.0.0.1:8081/interact/getData?dt={dt}&ht={ht}"
            ResponseEntity<String> responseEntity = null;

            HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
            if(params!=null) {
               responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, params);
            }
            else{
                responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            }

            String  jsonString = responseEntity.getBody().toString();
            int code = responseEntity.getStatusCodeValue();
            log.info("Status:"+code);
            return jsonString;
        }
        catch (Exception ex){
            log.info(ex.toString());
            return null;
        }
    }


    public void post(String url,Object obj) {
        try {
            RestTemplate template = new RestTemplate();
            //发起post请求
            ResponseEntity<Void> result = template.postForEntity(url, obj, Void.class);
        }
        catch (Exception ex){
            log.info(ex.toString());
        }
    }

    public void put(String url,Object obj) {
        try {

            RestTemplate template = new RestTemplate();
            //发起post请求
            template.put(url, obj);
        }
        catch (Exception ex) {
            log.info(ex.toString());
        }
    }

    public void delete(String url) {
        try {
            RestTemplate template = new RestTemplate();
            //发起delete请求
            template.delete(url);
        }
        catch (Exception ex) {
            log.info(ex.toString());
        }
    }
}
