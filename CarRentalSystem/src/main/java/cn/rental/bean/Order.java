package cn.rental.bean;

import java.util.Date;

public class Order {
    private int ORDER_ID;
    private String OWNER_NAME;
    private String HIRER_NAME;
    private Date START_TIME;
    private Date END_TIME;
    private String VEHICLE_TYPE;
    private int STATUS;
    private double AMOUNT;
    private String VEHICLE_ID;
    private String VEHICLE_BRAND;

    public Order() {

    }

    public Order(String OWNER_NAME, String HIRER_NAME, Date START_TIME, Date END_TIME, String VEHICLE_TYPE, int STATUS, double AMOUNT, String VEHICLE_ID, String VEHICLE_BRAND) {
        this.OWNER_NAME = OWNER_NAME;
        this.HIRER_NAME = HIRER_NAME;
        this.START_TIME = START_TIME;
        this.VEHICLE_TYPE = VEHICLE_TYPE;
        this.STATUS = STATUS;
        this.AMOUNT = AMOUNT;
        this.VEHICLE_ID = VEHICLE_ID;
        this.VEHICLE_BRAND = VEHICLE_BRAND;
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public String getOWNER_NAME() {
        return OWNER_NAME;
    }

    public void setOWNER_NAME(String OWNER_NAME) {
        this.OWNER_NAME = OWNER_NAME;
    }

    public String getHIRER_NAME() {
        return HIRER_NAME;
    }

    public void setHIRER_NAME(String HIRER_NAME) {
        this.HIRER_NAME = HIRER_NAME;
    }

    public Date getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(Date START_TIME) {
        this.START_TIME = START_TIME;
    }

    public Date getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(Date END_TIME) {
        this.END_TIME = END_TIME;
    }

    public String getVEHICLE_TYPE() {
        return VEHICLE_TYPE;
    }

    public void setVEHICLE_TYPE(String VEHICLE_TYPE) {
        this.VEHICLE_TYPE = VEHICLE_TYPE;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public double getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(double AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getVEHICLE_ID() {
        return VEHICLE_ID;
    }

    public void setVEHICLE_ID(String VEHICLE_ID) {
        this.VEHICLE_ID = VEHICLE_ID;
    }

    public String getVEHICLE_BRAND() {
        return VEHICLE_BRAND;
    }

    public void setVEHICLE_BRAND(String VEHICLE_BRAND) {
        this.VEHICLE_BRAND = VEHICLE_BRAND;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ORDER_ID=" + ORDER_ID +
                ", OWNER_NAME='" + OWNER_NAME + '\'' +
                ", HIRER_NAME='" + HIRER_NAME + '\'' +
                ", START_TIME=" + START_TIME +
                ", END_TIME=" + END_TIME +
                ", VEHICLE_TYPE='" + VEHICLE_TYPE + '\'' +
                ", STATUS=" + STATUS +
                ", AMOUNT=" + AMOUNT +
                ", VEHICLE_ID='" + VEHICLE_ID + '\'' +
                ", VEHICLE_BRAND='" + VEHICLE_BRAND + '\'' +
                '}';
    }
}
