package org.mdt.ulsanproject.repository;

import org.mdt.ulsanproject.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {

}
