package com.aip.aip.farmer;

import com.aip.aip.farmDetails.FarmDetails;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table
public class Farmer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "farmer_id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "farm_id")
    private FarmDetails farm;
    private String national_id;
    private String fullName;
    private long bankAccount;

    public Farmer() {
    }

    public Farmer(int farmerId, FarmDetails farm, String national_id, String fullName, long bankAccount) {
        this.id = id;
        this.farm = farm;
        this.national_id = national_id;
        this.fullName = fullName;
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public FarmDetails getFarm() {
        return farm;
    }

    public void setFarm(FarmDetails farm) {
        this.farm = farm;
    }

    public void setFarmerId(int farmerId) {
        this.id = id;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "CropFarmer{" +
                "id=" + id +
                ", national_id='" + national_id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }

    public String buySubsidy(long supplierAccount) {

        return "";
    }

    public void alertFarmerMessage(long phoneNumber) {

    }


}
