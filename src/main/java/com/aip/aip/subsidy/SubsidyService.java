package com.aip.aip.subsidy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsidyService {
    private final SubsidyRepository subsidyRepository;

    @Autowired
    public SubsidyService(SubsidyRepository subsidyRepository) {
        this.subsidyRepository = subsidyRepository;
    }

    public List<CropSubsidy> getSubsidy(String nationalId) {

        return subsidyRepository.findAllByFarmer(nationalId);
    }

    public CropSubsidy addSubsidy(CropSubsidy cropSubsidy) {
        subsidyRepository.save(cropSubsidy);

        return cropSubsidy;
    }

}
