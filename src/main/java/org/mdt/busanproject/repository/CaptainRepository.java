package org.mdt.busanproject.repository;

import org.mdt.busanproject.model.Captain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Integer> {
    Captain findByEmail(String email);
}
