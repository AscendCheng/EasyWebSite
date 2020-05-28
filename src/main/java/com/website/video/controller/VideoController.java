package com.website.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.video.domain.Video;
import com.website.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("video")
public class VideoController {


    @Autowired
    private VideoService videoService;

    @GetMapping("/getAll")
    public Object getAll() {
        return videoService.getAll();
    }

    @GetMapping("/getVideoById/{id}")
    public Object getVideoById(@PathVariable("id") int id) {
        return videoService.getVideoById(id);
    }

    @PutMapping("/updateVideo")
    public Object updateVideo(@RequestBody Video video) {
        return videoService.updateVideo(video);
    }

    @DeleteMapping("/deletedVideo/{id}")
    public Object deleteVideo(@PathVariable("id") int id) {
        return videoService.deleteVideo(id);
    }

    @GetMapping("/getByPage")
    public Object getAll(@RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Video> list = videoService.getAll();
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
