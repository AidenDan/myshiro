package com.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    @Column(name= "create_date") //创建时间
    Date createDate = new Date();

    @Column(name= "update_date")//修改时间
    Date updateDate;

}
