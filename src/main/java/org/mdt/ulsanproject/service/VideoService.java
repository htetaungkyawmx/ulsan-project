package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.VideoDto;
import org.mdt.ulsanproject.model.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {
    Video save(VideoDto videoDto);
    Optional<Video> update(int id, VideoDto videoDto);
    List<Video> findAll();
    Optional<Video> findById(int id);
    void delete(int id);
}
