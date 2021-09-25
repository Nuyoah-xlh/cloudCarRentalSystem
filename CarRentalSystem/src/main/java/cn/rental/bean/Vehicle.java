package cn.rental.bean;

import java.util.Date;

public class Vehicle {
    private String VEHICLE_ID;
    private String VEHICLE_TYPE;
    private String VEHICLE_BRAND;
    private String OWNER_ID;
    private int DURATION;
    private int STATUS;
    private double RENTAL_PRICE;
    private Date DEADLINE;
    private String LOCATION;

    public Vehicle() {

    }

    public Vehicle(String VEHICLE_ID, String VEHICLE_TYPE, String VEHICLE_BRAND, String OWNER_ID, int DURATION, int STATUS, double RENTAL_PRICE, Date DEADLINE, String LOCATION) {
        this.VEHICLE_ID = VEHICLE_ID;
        this.VEHICLE_TYPE = VEHICLE_TYPE;
        this.VEHICLE_BRAND = VEHICLE_BRAND;
        this.OWNER_ID = OWNER_ID;
        this.DURATION = DURATION;
        this.STATUS = STATUS;
        this.RENTAL_PRICE = RENTAL_PRICE;
        this.DEADLINE = DEADLINE;
        this.LOCATION = LOCATION;
    }

    public String getVEHICLE_ID() {
        return VEHICLE_ID;
    }

    public void setVEHICLE_ID(String VEHICLE_ID) {
        this.VEHICLE_ID = VEHICLE_ID;
    }

    public String getVEHICLE_TYPE() {
        return VEHICLE_TYPE;
    }

    public void setVEHICLE_TYPE(String VEHICLE_TYPE) {
        this.VEHICLE_TYPE = VEHICLE_TYPE;
    }

    public String getVEHICLE_BRAND() {
        return VEHICLE_BRAND;
    }

    public void setVEHICLE_BRAND(String VEHICLE_BRAND) {
        this.VEHICLE_BRAND = VEHICLE_BRAND;
    }

    public String getOWNER_ID() {
        return OWNER_ID;
    }

    public void setOWNER_ID(String OWNER_ID) {
        this.OWNER_ID = OWNER_ID;
    }

    public int getDURATION() {
        return DURATION;
    }

    public void setDURATION(int DURATION) {
        this.DURATION = DURATION;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public double getRENTAL_PRICE() {
        return RENTAL_PRICE;
    }

    public void setRENTAL_PRICE(double RENTAL_PRICE) {
        this.RENTAL_PRICE = RENTAL_PRICE;
    }

    public Date getDEADLINE() {
        return DEADLINE;
    }

    public void setDEADLINE(Date DEADLINE) {
        this.DEADLINE = DEADLINE;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

}
