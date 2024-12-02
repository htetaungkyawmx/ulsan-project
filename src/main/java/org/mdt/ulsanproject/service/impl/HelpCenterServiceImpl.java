package org.mdt.ulsanproject.service.impl;

import org.mdt.ulsanproject.repository.HelpCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpCenterServiceImpl {
    @Autowired
    private HelpCenterRepository helpCenterRepository;

}
