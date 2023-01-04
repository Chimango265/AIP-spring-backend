package com.aip.aip.subsidy;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/get_subsidy")
public class CropSubsidyController {

    private final SubsidyService subsidyService;

    @Autowired
    public CropSubsidyController(SubsidyService subsidyService) {
        this.subsidyService = subsidyService;
    }

    @GetMapping
    public List<CropSubsidy> getSubsidy(String nationalId) {
        return subsidyService.getSubsidy(nationalId);
    }

    @GetMapping(path = "get_collected")
    public List<Boolean> getSubsidyIfCollected() {
        return subsidyService.getSubsidyIfCollected();
    }



    @PostMapping
    public void collectSubsidy(String nationalId) {
        subsidyService.collectSubsidy(nationalId);
    }
}
