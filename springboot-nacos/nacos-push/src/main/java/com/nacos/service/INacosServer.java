package com.nacos.service;

import com.nacos.entiy.Queue;
import com.nacos.util.HttpClientResult;

import java.util.List;

/**
 * @program: springboot-nacos
 * @description: nacos推送
 * @author: yjgl
 * @date: 2021-03-14 19:24
 **/
public interface INacosServer {
    HttpClientResult pushNacos(List<Queue> queues);

}
