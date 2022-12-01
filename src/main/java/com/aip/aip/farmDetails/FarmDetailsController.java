package com.aip.aip.farmDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/register_farm")
public class FarmDetailsController {

    private final FarmDetailsService farmDetailsService;

    @Autowired

    public FarmDetailsController(FarmDetailsService farmDetailsService) {
        this.farmDetailsService = farmDetailsService;
    }

    @GetMapping
    public List<FarmDetails> getFarmDetails() {
        return farmDetailsService.getFarmDetails();
    }

    @PostMapping
    public FarmDetails addNewFarm(@RequestBody FarmDetails farm) {
        return farmDetailsService.addNewFarm(farm);
    }
}
