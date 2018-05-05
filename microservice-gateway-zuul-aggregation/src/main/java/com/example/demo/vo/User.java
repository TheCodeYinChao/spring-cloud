package com.example.demo.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Admin on 2018/5/5.
 */
@Data
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

}
