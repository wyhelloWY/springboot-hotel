package com.jxau.hotelsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxau.hotelsystem.dao.UserDao;
import com.jxau.hotelsystem.pojo.DO.UserList;
import com.jxau.hotelsystem.service.UserService;
import com.jxau.hotelsystem.utils.PageRequest;
import com.jxau.hotelsystem.utils.PageResult;
import com.jxau.hotelsystem.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 16:25
 */
@Service
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public List<UserList> selectPage() {
        return userDao.selectPage();
    }

    @Override
    public int insertUserList(UserList userList) {
        return userDao.insertUserList(userList);
    }

    @Override
    public int updateUserList(UserList userList) {
        return userDao.updateUserList(userList);
    }

    @Override
    public int deleteUserList(int userId) {
        return userDao.deleteUserList(userId);
    }

    @Override
    public UserList selectUserListByUserPhone(String userPhone) {
        return userDao.selectUserListByUserPhone(userPhone);
    }

    @Override
    public UserList selectUserListByUserId(int userId) {
        return userDao.selectUserListByUserId(userId);
    }

    @Override
    public int selectPhoneExist(String userPhone) {
        return userDao.selectPhoneExist(userPhone);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }
    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<?> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<UserList> sysMenus = userDao.selectPage();
        return new PageInfo<UserList>(sysMenus);
    }
    @Override
    public List<UserList> getUserList(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<UserList> sysMenus = userDao.selectPage();
        return sysMenus;
    }

    @Override
    public UserList selectUserByKey(String userKey) {
        return userDao.selectUserByKey(userKey);
    }

    @Override
    public List<UserList> listByKeyWord(String key) {
        return userDao.listByKeyWord(key);

    }

    @Override
    public List<UserList> selectAllByMember() {
        return userDao.selectAllByMember();
    }

    @Override
    public List<UserList> getMemberList(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<UserList> sysMenus = userDao.selectAllByMember();
        return sysMenus;
    }
    private PageInfo<?> getPageMemberInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<UserList> sysMenus = userDao.selectAllByMember();
        return new PageInfo<UserList>(sysMenus);
    }
}
