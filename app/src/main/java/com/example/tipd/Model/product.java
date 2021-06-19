package com.example.tipd.Model;

public class product {
    public  int id;
    public String hsCode;
    public String hsDescription;
    public  String unit;
    public String vat;
    public String customsDuty;
    public String surcharge;
    public String cessLevy;
    public String pal;
    public String ridl;
    public String srl;
    public String nbt;
    public String exciseDuty;


    public product(int id, String hsCode, String hsDescription, String unit, String vat, String customsDuty, String surcharge, String cessLevy, String pal, String ridl, String srl, String nbt, String exciseDuty) {
        this.id = id;
        this.hsCode = hsCode;
        this.hsDescription = hsDescription;
        this.unit = unit;
        this.vat = vat;
        this.customsDuty = customsDuty;
        this.surcharge = surcharge;
        this.cessLevy = cessLevy;
        this.pal = pal;
        this.ridl = ridl;
        this.srl = srl;
        this.nbt = nbt;
        this.exciseDuty = exciseDuty;
    }






    public product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getHsDescription() {
        return hsDescription;
    }

    public void setHsDescription(String hsDescription) {
        this.hsDescription = hsDescription;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getCustomsDuty() {
        return customsDuty;
    }

    public void setCustomsDuty(String customsDuty) {
        this.customsDuty = customsDuty;
    }

    public String getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(String surcharge) {
        this.surcharge = surcharge;
    }

    public String getCessLevy() {
        return cessLevy;
    }

    public void setCessLevy(String cessLevy) {
        this.cessLevy = cessLevy;
    }

    public String getPal() {
        return pal;
    }

    public void setPal(String pal) {
        this.pal = pal;
    }

    public String getRidl() {
        return ridl;
    }

    public void setRidl(String ridl) {
        this.ridl = ridl;
    }

    public String getSrl() {
        return srl;
    }

    public void setSrl(String srl) {
        this.srl = srl;
    }

    public String getNbt() {
        return nbt;
    }

    public void setNbt(String nbt) {
        this.nbt = nbt;
    }

    public String getExciseDuty() {
        return exciseDuty;
    }

    public void setExciseDuty(String exciseDuty) {
        this.exciseDuty = exciseDuty;
    }
}


