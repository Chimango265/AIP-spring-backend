package com.aip.aip.farmDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmDetailsService {

    private final FarmDetailsRepository farmDetailsRepository;

    @Autowired
    public FarmDetailsService(FarmDetailsRepository farmDetailsRepository) {
        this.farmDetailsRepository = farmDetailsRepository;
    }

    public List<FarmDetails> getFarmDetails() {
        return farmDetailsRepository.findAll();
    }

    public FarmDetails addNewFarm(FarmDetails farm) {
        farmDetailsRepository.save(farm);

        return farm;
    }
}
