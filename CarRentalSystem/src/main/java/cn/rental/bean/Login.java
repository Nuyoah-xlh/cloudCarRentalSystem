package cn.rental.bean;

import lombok.Data;

//@Data
public class Login {
    private String USER_NAME;
    private String PASSWORD;
    private String LAST_TIME;
    private int TIMES;
    private int STATE;
    private String REGISTER_TIME;
    private int USER_TYPE;

    public Login() {

    }

    public Login(String USER_NAME, String PASSWORD, String LAST_TIME, int TIMES, int STATE, String REGISTER_TIME, int USER_TYPE) {
        this.USER_NAME = USER_NAME;
        this.PASSWORD = PASSWORD;
        this.LAST_TIME = LAST_TIME;
        this.TIMES = TIMES;
        this.STATE = STATE;
        this.REGISTER_TIME = REGISTER_TIME;
        this.USER_TYPE = USER_TYPE;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getLAST_TIME() {
        return LAST_TIME;
    }

    public void setLAST_TIME(String LAST_TIME) {
        this.LAST_TIME = LAST_TIME;
    }

    public int getTIMES() {
        return TIMES;
    }

    public void setTIMES(int TIMES) {
        this.TIMES = TIMES;
    }

    public int getSTATE() {
        return STATE;
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
    }

    public String getREGISTER_TIME() {
        return REGISTER_TIME;
    }

    public void setREGISTER_TIME(String REGISTER_TIME) {
        this.REGISTER_TIME = REGISTER_TIME;
    }

    public int getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(int USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }
}
