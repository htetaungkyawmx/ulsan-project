package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.FeedBackDto;
import org.mdt.ulsanproject.model.FeedBack;
import org.mdt.ulsanproject.model.Users;
import org.mdt.ulsanproject.repository.FeedBackRepository;
import org.mdt.ulsanproject.repository.UsersRepository;
import org.mdt.ulsanproject.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public FeedBack save(FeedBackDto feedBackDto) {
        // Check if the user exists by the given user ID
        Optional<Users> userOptional = usersRepository.findById(feedBackDto.getUserId());
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + feedBackDto.getUserId() + " does not exist");
        }

        // Retrieve the user object
        Users user = userOptional.get();

        // Create a new FeedBack entity and associate the user
        FeedBack feedBack = FeedBack.builder()
                .content(feedBackDto.getContent())
                .user(user)  // Link the feedback to the user
                .build();

        // Save and return the feedback
        return feedBackRepository.save(feedBack);
    }

    @Override
    public Optional<FeedBack> update(int id, FeedBackDto feedBackDto) {
        // Find existing feedback by ID
        Optional<FeedBack> existingFeedBackOptional = feedBackRepository.findById(id);

        // If feedback does not exist, throw exception
        if (existingFeedBackOptional.isEmpty()) {
            throw new IllegalArgumentException("Feedback with ID " + id + " does not exist");
        }

        // Update the feedback if it exists
        FeedBack existingFeedBack = existingFeedBackOptional.get();
        existingFeedBack.setContent(feedBackDto.getContent());

        // Check if the user exists by the given user ID
        Optional<Users> userOptional = usersRepository.findById(feedBackDto.getUserId());
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + feedBackDto.getUserId() + " does not exist");
        }

        // Set the user for the existing feedback
        Users user = userOptional.get();
        existingFeedBack.setUser(user);

        // Save and return the updated feedback
        return Optional.of(feedBackRepository.save(existingFeedBack));
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
