package com.springboot.demo.base.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysPermissionVo{

    @Id
    private Integer id;//主键.
    private String text;//名称.
    private String parent;//资源路径.
    private Boolean state;//状态


}