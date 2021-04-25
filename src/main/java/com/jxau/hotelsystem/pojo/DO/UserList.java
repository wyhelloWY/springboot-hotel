package com.jxau.hotelsystem.pojo.DO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 15:29
 */
@Data
public class UserList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPass;

    /**
     * 用户身份证号
     */
    private String userCardId;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 真实姓名
     */
    private String userRealname;

    /**
     * 性别
     */
    private String userSex;

    /**
     * 年龄
     */
    private Integer userAge;

    /**
     * 认证状态
     */
    private Integer userAuthentication;

    /**
     * 最后登录时间
     */
    private Date userLoginDate;

    /**
     * 注册时间
     */
    private Date userRegisterDate;

    /**
     * 电话号
     */
    private String userPhone;

    public UserList() {
    }

}
