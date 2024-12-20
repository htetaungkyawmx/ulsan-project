package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.FeedBackDto;
import org.mdt.ulsanproject.model.FeedBack;
import org.mdt.ulsanproject.model.Users;
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

    // Save feedback
    @Override
    public FeedBack save(FeedBackDto feedBackDto) {
        // Ensure that the user ID exists in the Users table
        Users user = new Users();
        user.setId(feedBackDto.getUserId()); // Set the user ID (make sure the ID is valid)

        FeedBack feedBack = FeedBack.builder()
                .content(feedBackDto.getContent())
                .user(user) // Set user object
                .build();
        return feedBackRepository.save(feedBack);
    }

    // Update feedback
    @Override
    public Optional<FeedBack> update(int id, FeedBackDto feedBackDto) {
        return feedBackRepository.findById(id).map(existingFeedBack -> {
            existingFeedBack.setContent(feedBackDto.getContent());
            Users user = new Users();
            user.setId(feedBackDto.getUserId()); // Set the user ID (make sure the ID is valid)
            existingFeedBack.setUser(user); // Set user object
            return feedBackRepository.save(existingFeedBack);
        });
    }

    // Get all feedback
    @Override
    public List<FeedBack> findAll() {
        return feedBackRepository.findAll();
    }

    // Find feedback by ID
    @Override
    public Optional<FeedBack> findById(int id) {
        return feedBackRepository.findById(id);
    }

    // Delete feedback
    @Override
    public void delete(int id) {
        feedBackRepository.deleteById(id);
    }
}
