package org.mdt.busanproject.repository;

import org.mdt.busanproject.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
    Guest findByEmail(String email);
}
