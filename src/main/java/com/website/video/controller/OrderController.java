package com.website.video.controller;

import com.website.video.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/add")
    public JsonResult saveOrder(){
        return JsonResult.success("成功");
    }
}
