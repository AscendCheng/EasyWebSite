package com.website.video.service.impl;

import com.website.video.dao.VideoMapper;
import com.website.video.domain.Video;
import com.website.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> getAll() {
        return videoMapper.getAll();
    }

    @Override
    public Video getVideoById(int id) {
        return videoMapper.getVideoById(id);
    }

    @Override
    public int updateVideo(Video video) {
        return videoMapper.update(video);
    }

    @Override
    public int deleteVideo(int id) {
        return videoMapper.delete(id);
    }
}
