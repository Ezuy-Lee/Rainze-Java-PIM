package com.liyuze.pim.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LYZ
 * @version 1.0
 * @description
 * @projectName ProjectIntegrationManagement
 * @data 2020/3/5 17:47
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String name;
    private String sex;
    private String score;
    private Integer age;




}
