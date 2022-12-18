package com.aip.aip.farmer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmerRepository extends
        JpaRepository<Farmer, Integer> {
    @Query("SELECT f FROM Farmer f WHERE f.national_id = ?1")
    Optional<Farmer> findFarmerByNationalId(String national_id);
}
