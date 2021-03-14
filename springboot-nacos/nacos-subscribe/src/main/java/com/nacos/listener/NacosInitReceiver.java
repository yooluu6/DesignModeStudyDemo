package com.nacos.listener;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nacos.entity.Queue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

/**
 * @description: 项目启动的时候向nacos获取初始化数据
 * @author: yjgl
 **/
@Component
@Slf4j
public class NacosInitReceiver implements ApplicationRunner {

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
     * nacos默认值
     */
    private final String INIT_VALUE = "{}";


    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            Properties properties = new Properties();
            properties.put("serverAddr", SERVICE_ADDR);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(DATA_ID, NACOS_GROUP, 5000);
            if(!INIT_VALUE.equals(content)){
                //todo 服务启动后初始化数据 将数据转化为list处理数据
                Gson gson = new Gson();
                List<Queue> queues = gson.fromJson(content,new TypeToken<List<Queue>>() {}.getType());
                log.info("=============================="+queues);
            }
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
