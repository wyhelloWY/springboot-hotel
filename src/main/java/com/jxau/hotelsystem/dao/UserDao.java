package com.jxau.hotelsystem.dao;

import com.jxau.hotelsystem.pojo.DO.UserList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 15:37
 */
@Mapper
public interface UserDao {
    /**
     * 查询全部
     * @return
     */
    List<UserList> selectPage();

    /**
     * 查询全部会员
     * @return
     */
    List<UserList> selectAllByMember();

    /**
     * 关键词查询
     * @param key
     * @return
     */
    List<UserList> listByKeyWord(String key);
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
     * 查询用户
     * @param userKey
     * @return
     */
    UserList selectUserByKey(String userKey);
}
