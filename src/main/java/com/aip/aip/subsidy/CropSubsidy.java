package com.aip.aip.subsidy;

import com.aip.aip.farmer.Farmer;

import javax.persistence.*;

@Entity
@Table(name="crop_subsidy")
public class CropSubsidy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subsidy_id")
    private int subsidyId;

    private String farmer;
    private double npk;
    private double urea;
    private String interCrop;

    private boolean collected;

    public CropSubsidy() {
    }

    public CropSubsidy(String farmer, double npk, double urea, String interCrop, boolean collected) {
        this.subsidyId = subsidyId;
        this.farmer = farmer;
        this.npk = npk;
        this.urea = urea;
        this.interCrop = interCrop;
        this.collected = collected;
    }

    public double getNpk() {
        return npk;
    }

    public void setNpk(double npk) {
        this.npk = npk;
    }

    public double getUrea() {
        return urea;
    }

    public void setUrea(double urea) {
        this.urea = urea;
    }

    public String getInterCrop() {
        return interCrop;
    }

    public void setInterCrop(String interCrop) {
        this.interCrop = interCrop;
    }

    public String getFarmer() {
        return farmer;
    }

    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    @Override
    public String toString() {
        return "CropSubsidy{" +
                "npk=" + npk +
                ", urea=" + urea +
                ", interCrop='" + interCrop + '\'' +
                '}';
    }
}
