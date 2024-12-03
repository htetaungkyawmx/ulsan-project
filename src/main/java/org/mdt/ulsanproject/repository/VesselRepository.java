package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.Vessel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselRepository extends JpaRepository<Vessel, Integer> {

}
