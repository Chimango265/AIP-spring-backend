package com.aip.aip.subsidy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubsidyRepository extends JpaRepository<CropSubsidy, Integer> {
    List<CropSubsidy> findAllByFarmer(String nationalId);

    //check if beneficiary has collected subsidy
    @Query(value = "SELECT collected FROM crop_subsidy WHERE farmer = ?1", nativeQuery = true)
    boolean isSubsidyCollected(String nationalId);

    //Update collected field to true after collection
    @Transactional
    @Modifying
    @Query(value = "UPDATE crop_subsidy SET collected = TRUE WHERE farmer = ?1 ", nativeQuery = true)
    void collectSubsidy(String nationalId);
}
