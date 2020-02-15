package com.springboot.demo.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "user_info")
public class UserInfo implements Serializable {

    @Id
    //@GeneratedValue
    private Integer uid=1;
    @Column(unique =true)
    private String username;//帐号
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String password; //密码;
    private String salt= "8d78869f470951332959580424d4bf4f";//加密密码的盐
    private int state=0;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.3: 已上传认证资料未审核. 4: 已上传认证资料审核未通过
    @Column(name= "create_date") //创建时间
    Date createDate = new Date();
    @Column(name= "update_date")//修改时间
    Date updateDate = new Date();
    @Column(name= "remarks")
    private String  remarks;//描述
    private String  phone;//手机
    private String  reason;//审核原因

   // @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    //@JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色


    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解

}