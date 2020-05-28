package com.website.video.dao;

import com.website.video.domain.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VideoMapper {
    @Select("SELECT * FROM video")
    List<Video> getAll();

    @Select("SELECT * FROM video where id = #{id}")
    Video getVideoById(int id);

    @Update("UPDATE video set title =#{title} where id = #{id}")
    int update(Video video);

    @Delete("DELETE FROM video where id = {id}")
    int delete(int id);
}
