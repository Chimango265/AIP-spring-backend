package com.aip.aip.farmer;

import org.apache.coyote.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    @Autowired
    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public List<Farmer> getBeneficiary() {
        return farmerRepository.findAll();

    }

    public Farmer addNewBeneficiary(Farmer farmer) {
        farmerRepository.save(farmer);


        return farmer;

    }


}
