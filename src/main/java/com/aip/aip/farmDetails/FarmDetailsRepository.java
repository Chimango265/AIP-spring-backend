package com.aip.aip.farmDetails;

import com.aip.aip.farmer.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmDetailsRepository extends
        JpaRepository<FarmDetails, Integer>{
}


