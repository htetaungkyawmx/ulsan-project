package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.dto.HelpCenterDto;
import org.mdt.ulsanproject.model.HelpCenter;
import org.mdt.ulsanproject.repository.HelpCenterRepository;
import org.mdt.ulsanproject.service.HelpCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpCenterServiceImpl implements HelpCenterService {
    @Autowired
    private HelpCenterRepository helpCenterRepository;

    @Override
    public HelpCenter save(HelpCenterDto helpCenterDto) {
        return null;
    }

    @Override
    public HelpCenter update(int id, HelpCenterDto helpCenterDto) {
        return null;
    }

    @Override
    public List<HelpCenter> findAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

}
