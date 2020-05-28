package com.website.video.service;


import com.website.video.domain.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAll();

    Video getVideoById(int id);

    int updateVideo(Video video);

    int deleteVideo(int id);
}
