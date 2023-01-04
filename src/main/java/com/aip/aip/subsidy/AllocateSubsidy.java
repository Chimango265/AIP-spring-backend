package com.aip.aip.subsidy;

import com.aip.aip.farmer.Farmer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AllocateSubsidy {

    private final SubsidyService subsidyService;

    @Autowired
    public AllocateSubsidy(SubsidyService subsidyService) {
        this.subsidyService = subsidyService;
    }

    public JSONObject allocateSubsidy(String farmer, String mainCrop, double farmSize, String soilHealth) {
        String interCrop;

        int npk = 47 + (int) (Math.random() * 170);
        int urea = 47 + (int) (Math.random() * 170);

        if (mainCrop.equals("maize")) {
            interCrop = "ground nuts";
        } else if (mainCrop.equals("ground nuts")) {
            interCrop = "maize";
        } else {
            interCrop = "soya";
        }

        JSONObject subsidy = new JSONObject();
        subsidy.put("npk", npk);
        subsidy.put("urea", urea);
        subsidy.put("intercrop", interCrop);

        CropSubsidy farmSubsidy = new CropSubsidy(farmer, npk, urea, interCrop, false);
        subsidyService.addSubsidy(farmSubsidy);

        return subsidy;
    }
}
