package com.example.boot.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;


@Data
@TableName("user")
public class User implements Serializable {

    @TableId(type=IdType.AUTO)
    private Integer id;

    private String name;
}
