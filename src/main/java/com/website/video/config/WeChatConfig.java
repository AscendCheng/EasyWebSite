package com.website.video.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class WeChatConfig {

    /**
     * 公众号id
     */
    @Value("${wxpay.appid}")
    private String appid;
    /**
     * 公众号密钥
     */
    @Value("${wxpay.secrit}")
    private String secrit;

    public String getAppid() {
        return appid;
    }

    public String getSecrit() {
        return secrit;
    }

}
