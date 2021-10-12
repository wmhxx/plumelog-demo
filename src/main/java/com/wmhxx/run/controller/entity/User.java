package com.wmhxx.run.controller.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :WangMengHe
 * @since :2021-10-11 15:13
 **/
@Data
public class User implements Serializable {

    private String name;

    private Integer age;

    private String address;

    private Integer sex;

}
