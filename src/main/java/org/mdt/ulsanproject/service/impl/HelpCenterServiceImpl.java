package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.HelpCenterDto;
import org.mdt.ulsanproject.model.HelpCenter;
import org.mdt.ulsanproject.repository.HelpCenterRepository;
import org.mdt.ulsanproject.service.HelpCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelpCenterServiceImpl implements HelpCenterService {
    @Autowired
    private HelpCenterRepository helpCenterRepository;

    @Override
    public HelpCenter save(HelpCenterDto helpCenterDto) {
        HelpCenter helpCenter = HelpCenter.builder()
                .question(helpCenterDto.getQuestion())
                .answer(helpCenterDto.getAnswer())
                .build();
        return helpCenterRepository.save(helpCenter);
    }

    @Override
    public Optional<HelpCenter> update(int id, HelpCenterDto helpCenterDto) {
        return helpCenterRepository.findById(id).map(existingHelpCenter -> {
            existingHelpCenter.setQuestion(helpCenterDto.getQuestion());
            existingHelpCenter.setAnswer(helpCenterDto.getAnswer());
            return helpCenterRepository.save(existingHelpCenter);
        });
    }

    @Override
    public List<HelpCenter> findAll() {
        return helpCenterRepository.findAll();
    }

    @Override
    public Optional<HelpCenter> findById(int id) {
        return helpCenterRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        helpCenterRepository.deleteById(id);
    }
}
