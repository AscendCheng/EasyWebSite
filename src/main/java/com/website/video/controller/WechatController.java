package com.website.video.controller;

import com.website.video.config.WeChatConfig;
import com.website.video.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("wechat")
public class WechatController {
    @Autowired
    private WeChatConfig wechatConfig;

    /**
     * 微信扫一扫
     */
    @GetMapping("/loginUrl")
    public JsonResult login(@RequestParam(value = "access_page", required = true) String accesPage) throws UnsupportedEncodingException {
        String redirectUrl = wechatConfig.getOpenRedirectUrl();
        String callbackUrl = URLEncoder.encode(redirectUrl, "GBK");
        String qrcodeUrl = String.format(wechatConfig.getOpenQrUrl(), wechatConfig.getOpenQrUrl(), callbackUrl, accesPage);
        return JsonResult.success(qrcodeUrl);
    }
}
