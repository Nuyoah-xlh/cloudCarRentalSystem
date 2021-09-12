package cn.rental.bean;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private double score;
}