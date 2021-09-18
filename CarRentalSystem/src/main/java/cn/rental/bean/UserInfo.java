package cn.rental.bean;

public class UserInfo {
    private String USER_NAME;
    private String NAME;
    private int SEX;
    private String TEL;
    private int USER_TYPE;
    private int CREDIT;
    private int STATE;
    private String ADMIN_ID;
    private String EMAIL;
    private double INCOME;
    private String ID;
    private String LOCATION;
    private int FREQUENCY;

    public UserInfo() {

    }

    public UserInfo(String USER_NAME, String NAME, int SEX, String TEL, int USER_TYPE, int CREDIT, int STATE, String ADMIN_ID, String EMAIL, double INCOME, String ID, String LOCATION, int FREQUENCY) {
        this.USER_NAME = USER_NAME;
        this.NAME = NAME;
        this.SEX = SEX;
        this.TEL = TEL;
        this.USER_TYPE = USER_TYPE;
        this.CREDIT = CREDIT;
        this.STATE = STATE;
        this.ADMIN_ID = ADMIN_ID;
        this.EMAIL = EMAIL;
        this.INCOME = INCOME;
        this.ID = ID;
        this.LOCATION = LOCATION;
        this.FREQUENCY = FREQUENCY;
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

    public int getSEX() {
        return SEX;
    }

    public void setSEX(int SEX) {
        this.SEX = SEX;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public int getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(int USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public int getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(int CREDIT) {
        this.CREDIT = CREDIT;
    }

    public int getSTATE() {
        return STATE;
    }

    public void setSTATE(int STATE) {
        this.STATE = STATE;
    }

    public String getADMIN_ID() {
        return ADMIN_ID;
    }

    public void setADMIN_ID(String ADMIN_ID) {
        this.ADMIN_ID = ADMIN_ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public double getINCOME() {
        return INCOME;
    }

    public void setINCOME(double INCOME) {
        this.INCOME = INCOME;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public int getFREQUENCY() {
        return FREQUENCY;
    }

    public void setFREQUENCY(int FREQUENCY) {
        this.FREQUENCY = FREQUENCY;
    }
}
