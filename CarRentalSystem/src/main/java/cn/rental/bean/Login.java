package cn.rental.bean;

import lombok.Data;

@Data
public class Login {
    private String USER_NAME;
    private String PASSWORD;
    private String LAST_TIME;
    private int TIMES;
    private int STATE;
    private String REGISTER_TIME;
    private int USER_TYPE;
}
