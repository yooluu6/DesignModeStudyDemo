package com.nacos.service.impl;

import com.google.gson.Gson;
import com.nacos.entiy.Queue;
import com.nacos.service.INacosServer;
import com.nacos.util.HttpClientResult;
import com.nacos.util.HttpClientUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: springboot-nacos
 * @description: nacos推送实现
 * @author: yjgl
 * @date: 2021-03-14 19:25
 **/
@Service
public class NacosServer implements INacosServer {

    /**
     * nacos dataId
     */
    private final String DATA_ID = "TEST";

    /**
     * nacos group
     */
    private final String NACOS_GROUP = "DEFAULT_GROUP";

    /**
     * nacos 服务器地址
     */
    private final String SERVICE_ADDR = "127.0.0.1:8848";

    /**
     *
     * @param queues
     * @return
     */
    @Override
    public HttpClientResult pushNacos(List<Queue> queues) {
        HashMap map = new HashMap();
        Gson gson = new Gson();
        String str = gson.toJson(queues);
        map.put("dataId",DATA_ID);
        map.put("group",NACOS_GROUP);
        map.put("content",str);
        HttpClientResult httpClientResult = null;
        try {
            httpClientResult = HttpClientUtil.doPost("http://" + SERVICE_ADDR + "/nacos/v1/cs/configs", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpClientResult;
    }
}
