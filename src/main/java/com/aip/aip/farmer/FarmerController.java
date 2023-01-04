package com.aip.aip.farmer;


import com.aip.aip.subsidy.AllocateSubsidy;
import com.aip.aip.subsidy.SubsidyService;
import com.stripe.exception.StripeException;
import org.apache.coyote.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/register")
public class FarmerController {
    private final FarmerService farmerService;
    private final SubsidyService subsidyService;

    @Autowired
    public FarmerController(FarmerService farmerService, SubsidyService subsidyService) {
        this.farmerService = farmerService;
        this.subsidyService = subsidyService;
    }

    @GetMapping
    public List<Farmer> getBeneficiary() {
        return farmerService.getBeneficiary();
    }

    @PostMapping
    public Farmer registerNewBeneficiary(@RequestBody Farmer farmer) throws StripeException {

        String name = farmer.getFullName();
        //new StripeAccount().customerCard(name);

        //for crop subsidy object

        String mainCrop = (farmer.getFarm()).getMainCrop();
        double farmSize = (farmer.getFarm()).getFarmSize();
        String soilHealth = (farmer.getFarm()).getSoilHealth();
        String nationalId = farmer.getNational_id();


        AllocateSubsidy sub = new AllocateSubsidy(subsidyService);
        sub.allocateSubsidy(nationalId, mainCrop, farmSize, soilHealth);
        return farmerService.addNewBeneficiary(farmer);

    }

}
