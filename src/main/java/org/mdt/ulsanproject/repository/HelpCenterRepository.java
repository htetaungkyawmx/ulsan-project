package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.HelpCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpCenterRepository extends JpaRepository<HelpCenter, Integer> {

}
