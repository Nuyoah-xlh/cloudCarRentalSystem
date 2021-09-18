package cn.rental.bean;

public class Hirer {
    private String USER_NAME;
    private String NAME;
    private int SEX;
    private String ID;
    private int CREDIT;
    private int FREQUENCY;
    private String EMAIL;
    private String TEL;

    public Hirer() {

    }

    public Hirer(String USER_NAME, String NAME, int SEX, String ID, int CREDIT, int FREQUENCY, String EMAIL, String TEL) {
        this.USER_NAME = USER_NAME;
        this.NAME = NAME;
        this.SEX = SEX;
        this.ID = ID;
        this.CREDIT = CREDIT;
        this.FREQUENCY = FREQUENCY;
        this.EMAIL = EMAIL;
        this.TEL = TEL;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(int CREDIT) {
        this.CREDIT = CREDIT;
    }

    public int getFREQUENCY() {
        return FREQUENCY;
    }

    public void setFREQUENCY(int FREQUENCY) {
        this.FREQUENCY = FREQUENCY;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }
}
