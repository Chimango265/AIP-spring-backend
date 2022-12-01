package com.aip.aip.farmDetails;

import com.aip.aip.farmer.Farmer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="farm")
public class FarmDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "farm_id")
    private int farmId;

    @OneToOne(mappedBy = "farm")
    private Farmer farmer;
    private int farmSize;
    private String soilHealth;
    private String mainCrop;
    private String location;

    public FarmDetails() {
    }

    public FarmDetails(int farmId, int farmSize, String soilHealth, String mainCrop, String location) {
        this.farmSize = farmSize;
        this.farmId = farmId;
        this.soilHealth = soilHealth;
        this.mainCrop = mainCrop;
        this.location = location;
    }

    public int getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(int farmSize) {
        this.farmSize = farmSize;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setId(int farmId) {
        this.farmId = farmId;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public String getSoilHealth() {
        return soilHealth;
    }

    public void setSoilHealth(String soilHealth) {
        this.soilHealth = soilHealth;
    }

    public String getMainCrop() {
        return mainCrop;
    }

    public void setMainCrop(String mainCrop) {
        this.mainCrop = mainCrop;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "FarmDetails{" +
                "farmSize=" + farmSize +
                ", soilHealth='" + soilHealth + '\'' +
                ", mainCrop='" + mainCrop + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
