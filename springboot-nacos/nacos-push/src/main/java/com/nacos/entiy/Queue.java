package com.nacos.entiy;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: springboot-nacos
 * @description: 队列实体
 * @author: yjgl
 * @date: 2021-03-14 19:33
 **/
@Data
public class Queue implements Serializable {

    private static final long serialVersionUID = 1L;

    private String queueId;

    private String queueName;

    private String queueDesc;

}
