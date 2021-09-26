package cn.rental.bean;


import javax.xml.crypto.Data;
import java.util.Date;

//@Data
public class Login {
    private String USER_NAME;
    private String PASSWORD;
    private Date LAST_TIME;
    private int TIMES;
    private int STATE;
    private Date REGISTER_TIME;
    private int USER_TYPE;

    public Login() {

    }

    public Login(String USER_NAME, String PASSWORD, Date LAST_TIME, int TIMES, int STATE, Date REGISTER_TIME, int USER_TYPE) {
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

    public Date getLAST_TIME() {
        return LAST_TIME;
    }

    public void setLAST_TIME(Date LAST_TIME) {
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

    public Date getREGISTER_TIME() {
        return REGISTER_TIME;
    }

    public void setREGISTER_TIME(Date REGISTER_TIME) {
        this.REGISTER_TIME = REGISTER_TIME;
    }

    public int getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(int USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }
}
