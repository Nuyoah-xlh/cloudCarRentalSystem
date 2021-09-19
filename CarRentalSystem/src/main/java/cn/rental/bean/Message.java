package cn.rental.bean;

import java.security.MessageDigest;
import java.util.Date;

public class Message {
    private int MESSAGE_ID;
    private String SEND_NAME;
    private String RECEIVE_NAME;
    private String DETAIL;
    private Date SEND_TIME;
    private int STATUS;

    public Message() {

    }

    public Message(String SEND_NAME, String RECEIVE_NAME, String DETAIL, Date SEND_TIME, int STATUS) {
        this.SEND_NAME = SEND_NAME;
        this.RECEIVE_NAME = RECEIVE_NAME;
        this.DETAIL = DETAIL;
        this.SEND_TIME = SEND_TIME;
        this.STATUS = STATUS;
    }

    public int getMESSAGE_ID() {
        return MESSAGE_ID;
    }

    public void setMESSAGE_ID(int MESSAGE_ID) {
        this.MESSAGE_ID = MESSAGE_ID;
    }

    public String getSEND_NAME() {
        return SEND_NAME;
    }

    public void setSEND_NAME(String SEND_NAME) {
        this.SEND_NAME = SEND_NAME;
    }

    public String getRECEIVE_NAME() {
        return RECEIVE_NAME;
    }

    public void setRECEIVE_NAME(String RECEIVE_NAME) {
        this.RECEIVE_NAME = RECEIVE_NAME;
    }

    public String getDETAIL() {
        return DETAIL;
    }

    public void setDETAIL(String DETAIL) {
        this.DETAIL = DETAIL;
    }

    public Date getSEND_TIME() {
        return SEND_TIME;
    }

    public void setSEND_TIME(Date SEND_TIME) {
        this.SEND_TIME = SEND_TIME;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }
}
