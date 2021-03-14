package com.nacos.controller;

import com.nacos.entiy.Queue;
import com.nacos.service.INacosServer;
import com.nacos.util.HttpClientResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: springboot-nacos
 * @description: 推送数据到nacos
 * @date: 2021-03-14 19:21
 **/
@RestController
public class NacosPushController {

    @Autowired
    private INacosServer nacosServer;

    /**
     * 推送配置到nacos
     * @return
     */
    @PostMapping("/pushNacos")
    public HttpClientResult pushNacos() throws Exception {

        //todo 可以查询数据 将数据推送到nacos
        List<Queue> queues = new ArrayList<>();
        Queue queue = new Queue();
        queue.setQueueId(UUID.randomUUID().toString());
        queue.setQueueName("nacos-test");
        queue.setQueueDesc("nacos测试");
        return nacosServer.pushNacos(queues);
    }
}
