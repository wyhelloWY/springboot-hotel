package com.jxau.hotelsystem.controller;

import com.jxau.hotelsystem.annotation.MyLog;
import com.jxau.hotelsystem.pojo.DO.HouseList;
import com.jxau.hotelsystem.pojo.DO.UserList;
import com.jxau.hotelsystem.pojo.ResultMap;
import com.jxau.hotelsystem.service.UserService;
import com.jxau.hotelsystem.utils.GetDateUtil;
import com.jxau.hotelsystem.utils.PageRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 16:32
 */
@Controller
@RequestMapping("/userApi")
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 分页查询
     * @param num
     * @param size
     * @return
     */
    @RequestMapping(value="/findPage")
    @ResponseBody
    public ResultMap findPage(@RequestParam(value = "page",required = false) int num,
                              @RequestParam(value = "limit",required = false)int size,
                              @RequestParam(value = "key",required = false)String key) {
        ResultMap resultMap = new ResultMap();
        List<UserList>  userInfos = new ArrayList<>();
        if(key ==null || key ==""){
            PageRequest pageQuery = new PageRequest();
            pageQuery.setPageNum(num);
            pageQuery.setPageSize(size);
            userInfos = userService.getUserList(pageQuery);
            resultMap.setCodeResultDataArrayMsg(200,"success","成功",userInfos,userInfos.size());
        }else{
            userInfos= userService.listByKeyWord(key);
            resultMap.setCodeResultDataArrayMsg(200,"success","成功",userInfos,userInfos.size());
        }
        return resultMap;
    }

    /**
     * 分页查询
     * @param num
     * @param size
     * @return
     */
    @RequestMapping(value="/findMemberPage")
    @ResponseBody
    public ResultMap findMemberPage(@RequestParam(value = "page",required = false) int num,
                              @RequestParam(value = "limit",required = false)int size,
                              @RequestParam(value = "key",required = false)String key) {
        ResultMap resultMap = new ResultMap();
        List<UserList>  userInfos = new ArrayList<>();
        if(key ==null || key ==""){
            PageRequest pageQuery = new PageRequest();
            pageQuery.setPageNum(num);
            pageQuery.setPageSize(size);
            userInfos = userService.getMemberList(pageQuery);
            resultMap.setCodeResultDataArrayMsg(200,"success","成功",userInfos,userInfos.size());
        }else{
            for(int i = 0; i < userInfos.size(); i++){
                if(userInfos.get(i).getUserType() != 3){
                    userInfos.remove(i);
                }
            }
            userInfos= userService.listByKeyWord(key);
            resultMap.setCodeResultDataArrayMsg(200,"success","成功",userInfos,userInfos.size());
        }
        return resultMap;
    }

    /**
     * 登录
     * @param userName
     * @param userPass
     * @param httpSession
     * @return
     */
    @RequestMapping(value="/login")
    @ResponseBody
    public ResultMap login(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "userPass")String userPass,
                           HttpSession httpSession) {
        ResultMap resultMap = new ResultMap();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,userPass);
        UserList userList = new UserList();
        userList = userService.selectUserByKey(userName);
        try {
            subject.login(token);
            if(userList == null){
                resultMap.setCodeResultMsg(201,"error","此用户不存在");
            }else{
                if(!userList.getUserPass().equals(userPass)){
                    resultMap.setCodeResultMsg(201,"success","密码错误");
                }else{
                    httpSession.setAttribute("userList",userList);
                    httpSession.setAttribute("userName",userList.getUserName());
                    userList.setUserLoginDate(GetDateUtil.getDateTime());
                    userService.updateUserList(userList);
                    resultMap.setCodeResultMsgFormData(200,"success","登录成功",userList.getUserType());
                }
            }
        }catch (IncorrectCredentialsException e){
            resultMap.setCodeResultMsg(201,"error","此用户不存在");
        }

        return resultMap;
    }

    /**
     * 注册用户  新建用户
     * @param userName
     * @param userPhone
     * @param userCardId
     * @param userPass
     * @return
     */
    @RequestMapping(value="/toRegister")
    @ResponseBody
    public ResultMap toRegister(@RequestParam(value = "userName") String userName,
                                @RequestParam(value = "userPhone")String userPhone,
                                @RequestParam(value = "userCardId")String userCardId,
                                @RequestParam(value = "userPass")String userPass) {
        ResultMap resultMap = new ResultMap();
        UserList userList = new UserList();
        userList.setUserName(userName);
        userList.setUserPhone(userPhone);
        userList.setUserCardId(userCardId);
        userList.setUserPass(userPass);
        userList.setUserType(1);
        userList.setUserRegisterDate(GetDateUtil.getDateTime());
        int flag = userService.insertUserList(userList);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","添加成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","添加失败");
        }
        return resultMap;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public ResultMap deleteUser(@RequestParam(value = "userId") String userId){
        int flag = userService.deleteUserList(Integer.valueOf(userId));
        ResultMap resultMap = new ResultMap();
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","删除成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","删除失败");
        }
        return resultMap;
    }
    /**
     * 新建用户
     * @param userName
     * @param userPhone
     * @param userCardId
     * @param userPass
     * @return
     */
    @RequestMapping(value="/addUser")
    @ResponseBody
    public ResultMap addUser(@RequestParam(value = "userName") String userName,
                                @RequestParam(value = "userPhone")String userPhone,
                                @RequestParam(value = "userCardId")String userCardId,
                                @RequestParam(value = "userPass")String userPass,
                                @RequestParam(value = "userRealname")String userRealname,
                                @RequestParam(value = "userType")String userType) {
        ResultMap resultMap = new ResultMap();
        UserList userList = new UserList();
        userList.setUserName(userName);
        userList.setUserPhone(userPhone);
        userList.setUserCardId(userCardId);
        userList.setUserPass(userPass);
        userList.setUserType(Integer.valueOf(userType));
        userList.setUserRealname(userRealname);
        userList.setUserRegisterDate(GetDateUtil.getDateTime());
        int flag = userService.insertUserList(userList);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","添加成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","添加失败");
        }
        return resultMap;
    }
    @RequestMapping(value="/selectUserById")
    public String selectHouseById(@RequestParam(value = "userId") String userId, Model model){
        UserList userList = userService.selectUserListByUserId(Integer.valueOf(userId));
        Map<String,Object> map = new HashMap<>();
        model.addAttribute("userList",userList);
        return "table/editUser";
    }

    /**
     * 修改用户
     * @param userId
     * @param userName
     * @param userPhone
     * @param userCardId
     * @param userPass
     * @param userType
     * @return
     */
    @RequestMapping(value="/editUser")
    @ResponseBody
    @MyLog(value = "")
    public ResultMap editUser(@RequestParam(value = "userId") String userId,
                             @RequestParam(value = "userName") String userName,
                             @RequestParam(value = "userPhone")String userPhone,
                              @RequestParam(value = "userRealname")String userRealname,
                             @RequestParam(value = "userCardId")String userCardId,
                             @RequestParam(value = "userPass")String userPass,
                             @RequestParam(value = "userType")String userType) {
        ResultMap resultMap = new ResultMap();
        UserList userList = new UserList();
        userList.setUserId(Integer.valueOf(userId));
        userList.setUserName(userName);
        userList.setUserPhone(userPhone);
        userList.setUserCardId(userCardId);
        userList.setUserPass(userPass);
        userList.setUserRealname(userRealname);
        userList.setUserType(Integer.valueOf(userType));
        userList.setUserRegisterDate(GetDateUtil.getDateTime());
        int flag = userService.updateUserList(userList);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","修改成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","修改失败");
        }
        return resultMap;
    }


}
