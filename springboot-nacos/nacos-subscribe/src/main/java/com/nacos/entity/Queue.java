package com.nacos.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 队列实体
 **/
@Data
public class Queue implements Serializable {

    private static final long serialVersionUID = 1L;

    private String queueId;

    private String queueName;

    private String queueDesc;

}
