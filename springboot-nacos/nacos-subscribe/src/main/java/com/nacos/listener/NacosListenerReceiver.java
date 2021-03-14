package com.nacos.listener;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nacos.entity.Queue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 监听nacos数据变化
 **/
@Configuration
@Slf4j
public class NacosListenerReceiver {

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

    /**
     * 配置动态代理 然后持续监听
     * @throws NacosException
     */
    @Bean
    public void onMessage() throws NacosException {
        Properties properties = new Properties();
        properties.put("serverAddr", SERVICE_ADDR);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(DATA_ID, NACOS_GROUP, 5000);
        System.out.println(content);
        configService.addListener(DATA_ID, NACOS_GROUP, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                if(!INIT_VALUE.equals(configInfo)){
                    //todo 监听到的是全量数据 所以记得调整数据
                    Gson gson = new Gson();
                    List<Queue> deliverRoutes = gson.fromJson(configInfo,new TypeToken<List<Queue>>() {}.getType());
                    log.info("recieve1:" + deliverRoutes);
                }
            }
            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }
}
