package com.example.demo.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
public class Info {

    @Id
    private String uuid;
    private String nameInput ;
    private String companyInput ;
    private String contactInput ;
    private String emailInput ;
    private String messageInput ;
    private Date createDate ;

}
