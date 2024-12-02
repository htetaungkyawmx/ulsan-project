package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.HelpCenterDto;
import org.mdt.ulsanproject.model.HelpCenter;

import java.util.List;

public interface HelpCenterService {
    HelpCenter save(HelpCenterDto helpCenterDto);
    HelpCenter update(int id, HelpCenterDto helpCenterDto);
    List<HelpCenter> findAll();
    void delete(int id);
}
