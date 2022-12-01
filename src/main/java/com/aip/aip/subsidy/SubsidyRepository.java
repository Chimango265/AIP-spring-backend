package com.aip.aip.subsidy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubsidyRepository extends JpaRepository<CropSubsidy, Integer> {
    List<CropSubsidy> findAllByFarmer(String nationalId);

}
