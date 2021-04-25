package com.jxau.hotelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName PageController
 * @Description: 页面控制
 * @date 2021/2/8 15:00
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "success";
    }


    @RequestMapping("/userManage")
    public String userManage(){
        return "userManage";
    }

    @RequestMapping("/frontIndex")
    public String frontIndex(){
        return "frontIndex";
    }

    @RequestMapping("/houseIndex")
    public String houseIndex(){
        return "houseIndex";
    }

    @RequestMapping("/addHouse")
    public String addHouse(){
        return "table/addHouse";
    }
    @RequestMapping("/addHouseType")
    public String addHouseType(){
        return "table/addHouseType";
    }
    @RequestMapping("/addUser")
    public String addUser(){
        return "table/addUser";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/center")
    public String center(){
        return "center";
    }

    @RequestMapping("/houseTypeIndex")
    public String houseTypeIndex(){
        return "houseTypeIndex";
    }


    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/memberManage")
    public String memberManage(){
        return "memberManage";
    }



    @RequestMapping("/memberOrderManage")
    public String memberOrderManage(){
        return "memberOrderManage";
    }


    @RequestMapping("/orderIndex")
    public String orderIndex(){
        return "orderIndex";
    }


    @RequestMapping("/roomManage")
    public String roomManage(){
        return "roomManage";
    }

    @RequestMapping("/roomTypeManage")
    public String roomTypeManage(){
        return "roomTypeManage";
    }

    @RequestMapping("/userOrderManage")
    public String userOrderManage(){
        return "userOrderManage";
    }

    @RequestMapping("/orderHouse")
    public String orderHouse(){
        return "table/orderHouse";
    }


}
