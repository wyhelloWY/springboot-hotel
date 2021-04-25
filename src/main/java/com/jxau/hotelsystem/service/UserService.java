package com.jxau.hotelsystem.service;

import com.jxau.hotelsystem.pojo.DO.UserList;
import com.jxau.hotelsystem.utils.PageRequest;
import com.jxau.hotelsystem.utils.PageResult;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 16:24
 */
public interface UserService {
    /**
     * 查询全部
     * @return
     */
    List<UserList> selectPage();

    /**
     * 插入用户
     * @param userList
     * @return
     */
    int insertUserList(UserList userList);

    /**
     * 修改用户
     * @param userList
     * @return
     */
    int updateUserList(UserList userList);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteUserList(int userId);

    /**
     * 查询用户
     * @param userPhone
     * @return
     */
    UserList selectUserListByUserPhone(String userPhone);

    /**
     * 查询用户
     * @param userId
     * @return
     */
    UserList selectUserListByUserId(int userId);

    /**
     * 查询是否存在此电话
     * @param userPhone
     * @return
     */
    int selectPhoneExist(String userPhone);

    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);

    /**
     * 得到数据
     * @param pageRequest
     * @return
     */
    List<UserList> getUserList(PageRequest pageRequest);

    /**
     * 查询用户
     * @param userKey
     * @return
     */
    UserList selectUserByKey(String userKey);

    /**
     * 关键词查询
     * @param key
     * @return
     */
    List<UserList> listByKeyWord(String key);


    /**
     * 查询全部会员
     * @return
     */
    List<UserList> selectAllByMember();

    /**
     * 得到数据
     * @param pageRequest
     * @return
     */
    List<UserList> getMemberList(PageRequest pageRequest);
}
