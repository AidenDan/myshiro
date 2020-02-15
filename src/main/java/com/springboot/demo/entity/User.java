package com.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User  {

    private String name;

    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="UUID")
    //@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
    private String id;

    @Column(name= "create_date") //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     Date createDate = new Date();

    @Column(name= "update_date")//修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     Date updateDate;

}
