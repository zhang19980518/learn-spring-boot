package com.example.boot.entity;

import lombok.Data;

import java.io.Serializable;

@Data

public class UserDemo implements Serializable {

    private String userName;

    private String password;

    private String name;
}