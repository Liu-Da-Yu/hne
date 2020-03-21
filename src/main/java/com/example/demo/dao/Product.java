package com.example.demo.dao;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id
    private String id;

    private String name;
    private String parent;
    private String size;
    private String voltage;
    private String energy;
    private String imgUrl;
    private String infoImgUrl;
    private String infoText;
    private String createTime;

}
