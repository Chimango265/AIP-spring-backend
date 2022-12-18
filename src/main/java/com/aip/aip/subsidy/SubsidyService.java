package com.aip.aip.subsidy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubsidyService {
    private final SubsidyRepository subsidyRepository;

    @Autowired
    public SubsidyService(SubsidyRepository subsidyRepository) {
        this.subsidyRepository = subsidyRepository;
    }

    public List<CropSubsidy> getSubsidy(String nationalId) {
        boolean subsidyCollected = subsidyRepository.isSubsidyCollected(nationalId);
        if (subsidyCollected == true) {
            throw new IllegalStateException("beneficiary has collected");
        }

        return subsidyRepository.findAllByFarmer(nationalId);
    }

    public CropSubsidy addSubsidy(CropSubsidy cropSubsidy) {
        subsidyRepository.save(cropSubsidy);

        return cropSubsidy;
    }

    public void collectSubsidy(String nationalId) {
        subsidyRepository.collectSubsidy(nationalId);
    }
}
