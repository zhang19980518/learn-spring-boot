package com.example.boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import javax.annotation.Generated;
import java.io.Serializable;


@Data
@Deprecated
public class User implements Serializable {

    private Integer id;

    private String name;
}
