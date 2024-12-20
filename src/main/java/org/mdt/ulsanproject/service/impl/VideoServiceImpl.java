package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.VideoDto;
import org.mdt.ulsanproject.model.Video;
import org.mdt.ulsanproject.repository.VideoRepository;
import org.mdt.ulsanproject.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video save(VideoDto videoDto) {
        Video video = Video.builder()
                .title(videoDto.getTitle())
                .description(videoDto.getDescription())
                .status(videoDto.getStatus())
                .createdAt(videoDto.getCreated_at())
                .url(videoDto.getUrl())
                .build();
        return videoRepository.save(video);
    }

    @Override
    public Optional<Video> update(int id, VideoDto videoDto) {
        return videoRepository.findById(id).map(existingVideo -> {
            existingVideo.setTitle(videoDto.getTitle());
            existingVideo.setDescription(videoDto.getDescription());
            existingVideo.setStatus(videoDto.getStatus());
            existingVideo.setCreatedAt(videoDto.getCreated_at());
            existingVideo.setUrl(videoDto.getUrl());
            return videoRepository.save(existingVideo);
        });
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> findById(int id) {
        return videoRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        videoRepository.deleteById(id);
    }
}
