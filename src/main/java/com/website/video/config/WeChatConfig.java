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

    /**
     * 公众号id
     */
    @Value("${wxpay.open.appid}")
    private String openAppid;
    /**
     * 公众号密钥
     */
    @Value("${wxpay.open.secrit}")
    private String openSecrit;

    /**
     * 回调url
     */
    @Value("${wxpay.open.redirectUrl}")
    private String openRedirectUrl;

    /**
     * 微信开发平台二维码链接
     */
    private final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect ";

    public String getOpenRedirectUrl(){
        return openRedirectUrl;
    }

    public String getOpenQrUrl(){
        return OPEN_QRCODE_URL;
    }

    public String getAppid() {
        return appid;
    }

    public String getSecrit() {
        return secrit;
    }

    public String getOpenAppid() {
        return appid;
    }

    public String getOpenSecrit() {
        return secrit;
    }


}
