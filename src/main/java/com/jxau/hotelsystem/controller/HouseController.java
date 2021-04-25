package com.jxau.hotelsystem.controller;

import com.jxau.hotelsystem.pojo.DO.HouseLayoutList;
import com.jxau.hotelsystem.pojo.DO.HouseList;
import com.jxau.hotelsystem.pojo.DO.UserList;
import com.jxau.hotelsystem.pojo.ResultMap;
import com.jxau.hotelsystem.service.HouseService;
import com.jxau.hotelsystem.utils.GetDateUtil;
import com.jxau.hotelsystem.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 17:33
 */
@Controller
@RequestMapping("/houseApi")
public class HouseController {
    @Autowired
    private HouseService houseService;


    /**
     * 分页查询
     * @param num
     * @param size
     * @return
     */
    @RequestMapping(value="/findHousePage")
    @ResponseBody
    public ResultMap findHousePage(@RequestParam(value = "page",required = false) int num,
                              @RequestParam(value = "limit",required = false)int size,
                                   @RequestParam(value = "key",required = false)String key) {
        ResultMap resultMap = new ResultMap();
        List<HouseList> houseLists = new ArrayList<>();
        if (key == null || key == "") {
            PageRequest pageQuery = new PageRequest();
            pageQuery.setPageNum(num);
            pageQuery.setPageSize(size);
            houseLists = houseService.getHouseList(pageQuery);
            resultMap.setCodeResultDataArrayMsg(200, "success", "成功", houseLists, houseLists.size());
        } else {
            houseLists = houseService.listAllHouseListByKey(key);
            resultMap.setCodeResultDataArrayMsg(200, "success", "成功", houseLists, houseLists.size());
        }
        return resultMap;
    }

    /**
     * 添加房源
     * @param houseNumber
     * @param houseExplanation
     * @param houseMoney
     * @param houseMemberMoney
     * @param houseType
     * @return
     */
    @RequestMapping("/addHouse")
    @ResponseBody
    public ResultMap addHouse(@RequestParam(value = "houseNumber") String houseNumber,
                              @RequestParam(value = "houseExplanation") String houseExplanation,
                              @RequestParam(value = "houseMoney") String houseMoney,
                              @RequestParam(value = "houseMemberMoney") String houseMemberMoney,
                              @RequestParam(value = "houseType") String houseType){
        ResultMap resultMap = new ResultMap();
        HouseList houseList = new HouseList();
        // 房间编号
        houseList.setHouseNumber(houseNumber);
        // 房间说明
        houseList.setHouseExplanation(houseExplanation);
        // 房间价钱
        houseList.setHouseMoney(Double.valueOf(houseMoney));
        // 会员价钱
        houseList.setHouseMemberMoney(Double.valueOf(houseMemberMoney));
        // 房间类型
        houseList.setHouseType(Integer.valueOf(houseType));
        // 房源创建时间
        houseList.setHouseDate(GetDateUtil.getDateTime());
        int flag = houseService.insertHouseList(houseList);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","添加成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","添加失败");
        }
        return resultMap;
    }

    /**
     * 返回值给前端 数据回显
     * @param houseId
     * @param model
     * @return
     */
    @RequestMapping("/selectHouseById")
    public String selectHouseById(@RequestParam(value = "houseId") String houseId,Model model){
        HouseList houseList = houseService.selectHouseListInfo(Integer.valueOf(houseId));
        Map<String,Object> map = new HashMap<>();
        model.addAttribute("houseList",houseList);
        return "table/editHouse";
    }


    /**
     * 预定房间前端 数据回显
     * @param houseId
     * @param model
     * @return
     */
    @RequestMapping("/selectHouseOrderById")
    public String selectHouseOrderById(@RequestParam(value = "houseId") String houseId,Model model){
        HouseList houseList = houseService.selectHouseListInfo(Integer.valueOf(houseId));
        Map<String,Object> map = new HashMap<>();
        model.addAttribute("houseList",houseList);
        return "table/orderHouse";
    }

    /**
     * 修改房源
     * @param houseId
     * @param houseNumber
     * @param houseExplanation
     * @param houseMoney
     * @param houseMemberMoney
     * @param houseType
     * @return
     */
    @RequestMapping("/updateHouseList")
    @ResponseBody
    public ResultMap updateHouseList(@RequestParam(value = "houseId") String houseId,
                                     @RequestParam(value = "houseNumber") String houseNumber,
                                     @RequestParam(value = "houseExplanation") String houseExplanation,
                                     @RequestParam(value = "houseMoney") String houseMoney,
                                     @RequestParam(value = "houseMemberMoney") String houseMemberMoney,
                                     @RequestParam(value = "houseType") String houseType){

        HouseList houseList = new HouseList();
        ResultMap resultMap = new ResultMap();
        houseList.setHouseId(Integer.valueOf(houseId));
        // 房间编号
        houseList.setHouseNumber(houseNumber);
        // 房间说明
        houseList.setHouseExplanation(houseExplanation);
        // 房间价钱
        houseList.setHouseMoney(Double.valueOf(houseMoney));
        // 会员价钱
        houseList.setHouseMemberMoney(Double.valueOf(houseMemberMoney));
        // 房间类型
        houseList.setHouseType(Integer.valueOf(houseType));
        // 房源创建时间
        houseList.setHouseDate(GetDateUtil.getDateTime());
        int flag = houseService.updateHouseList(houseList);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","修改成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","修改失败");
        }
        return resultMap;
    }

    /**
     * 删除
     * @param houseId
     * @return
     */
    @RequestMapping("/deleteHouseList")
    @ResponseBody
    public ResultMap deleteHouseList(@RequestParam(value = "houseId") String houseId){
        int flag = houseService.deleteHouseList(Integer.valueOf(houseId));
        ResultMap resultMap = new ResultMap();
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","删除成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","删除失败");
        }
        return resultMap;
    }




}
