package com.nacos.util;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: httpclient响应结果
 * @author: yjgl
 * @date: 2021-03-08 16:53
 **/
@Data
@Builder
public class HttpClientResult implements Serializable {

    private static final long serialVersionUID = 7465840423782484546L;
    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;
}
