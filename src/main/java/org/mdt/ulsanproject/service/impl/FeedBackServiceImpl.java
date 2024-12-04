package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.FeedBackDto;
import org.mdt.ulsanproject.model.FeedBack;
import org.mdt.ulsanproject.repository.FeedBackRepository;
import org.mdt.ulsanproject.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public FeedBack save(FeedBackDto feedBackDto) {
        FeedBack feedBack = FeedBack.builder()
                .rating(feedBackDto.getRating())
                .comment(feedBackDto.getComment())
                .created_at(feedBackDto.getCreated_at())
                .user_id(feedBackDto.getUser_id())
                .build();
        return feedBackRepository.save(feedBack);
    }

    @Override
    public Optional<FeedBack> update(int id, FeedBackDto feedBackDto) {
        return feedBackRepository.findById(id).map(existingFeedBack -> {
            existingFeedBack.setRating(feedBackDto.getRating());
            existingFeedBack.setComment(feedBackDto.getComment());
            existingFeedBack.setCreated_at(feedBackDto.getCreated_at());
            existingFeedBack.setUser_id(feedBackDto.getUser_id());
            return feedBackRepository.save(existingFeedBack);
        });
    }

    @Override
    public List<FeedBack> findAll() {
        return feedBackRepository.findAll();
    }

    @Override
    public Optional<FeedBack> findById(int id) {
        return feedBackRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        feedBackRepository.deleteById(id);
    }

}
