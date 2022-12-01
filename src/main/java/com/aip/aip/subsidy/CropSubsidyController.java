package com.aip.aip.subsidy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
