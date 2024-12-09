package org.mdt.ulsanproject.service;

import org.mdt.ulsanproject.dto.HelpCenterDto;
import org.mdt.ulsanproject.model.HelpCenter;

import java.util.List;
import java.util.Optional;

public interface HelpCenterService {
    HelpCenter save(HelpCenterDto helpCenterDto);
    Optional<HelpCenter> update(int id, HelpCenterDto helpCenterDto);
    List<HelpCenter> findAll();
    Optional<HelpCenter> findById(int id);
    void delete(int id);
}
