package cn.rental.bean;

import java.util.Date;

public class AdminInfo {
    private String ADMIN_ID;
    private String USER_NAME;
    private String NAME;
    private int USER_TYPE;
    private int STATE;
    private Date LAST_TIME;

    public AdminInfo() {

    }

    public AdminInfo(String ADMIN_ID, String USER_NAME, String NAME, int USER_TYPE, int STATE) {
        this.ADMIN_ID = ADMIN_ID;
        this.USER_NAME = USER_NAME;
        this.NAME = NAME;
        this.USER_TYPE = USER_TYPE;
        this.STATE = STATE;
    }

    public String getADMIN_ID() {
        return ADMIN_ID;
    }

    public void setADMIN_ID(String ADMIN_ID) {
        this.ADMIN_ID = ADMIN_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(int USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public int getSTATE() {
        return STATE;
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
    }

    public Date getLAST_TIME() {
        return LAST_TIME;
    }

    public void setLAST_TIME(Date LAST_TIME) {
        this.LAST_TIME = LAST_TIME;
    }
}
