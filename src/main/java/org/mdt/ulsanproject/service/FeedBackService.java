package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.FeedBackDto;
import org.mdt.ulsanproject.model.FeedBack;

import java.util.List;
import java.util.Optional;

public interface FeedBackService {
    FeedBack save(FeedBackDto feedBackDto);

    Optional<FeedBack> update(int id, FeedBackDto feedBackDto);

    List<FeedBack> findAll();

    Optional<FeedBack> findById(int id);

    void delete(int id);
}
