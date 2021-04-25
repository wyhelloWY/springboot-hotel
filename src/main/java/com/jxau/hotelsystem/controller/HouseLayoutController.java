package com.jxau.hotelsystem.controller;

import com.jxau.hotelsystem.pojo.DO.HouseLayoutList;
import com.jxau.hotelsystem.pojo.DO.HouseList;
import com.jxau.hotelsystem.pojo.DO.OrderList;
import com.jxau.hotelsystem.pojo.DO.UserList;
import com.jxau.hotelsystem.pojo.ResultMap;
import com.jxau.hotelsystem.service.HouseLayoutService;
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
 * @date 2021/2/8 17:34
 */
@Controller
@RequestMapping("/houseLayoutApi")
public class HouseLayoutController {

    @Autowired
    private HouseLayoutService houseLayoutService;
    /**
     * 分页查询
     * @param num
     * @param size
     * @return
     */
    @RequestMapping(value="/findHouseLayoutPage")
    @ResponseBody
    public ResultMap findHouseLayoutPage(@RequestParam(value = "page",required = false) int num,
                                         @RequestParam(value = "limit",required = false)int size,
                                         @RequestParam(value = "key",required = false)String key) {
        ResultMap resultMap = new ResultMap();
        List<HouseLayoutList> houseLayoutLists = new ArrayList<>();
        if (key == null || key == "") {
            PageRequest pageQuery = new PageRequest();
            pageQuery.setPageNum(num);
            pageQuery.setPageSize(size);
            houseLayoutLists = houseLayoutService.getHouseLayoutList(pageQuery);
            resultMap.setCodeResultDataArrayMsg(200, "success", "成功", houseLayoutLists, houseLayoutLists.size());
        } else {
            houseLayoutLists = houseLayoutService.listAllHouseLayoutByKey(key);
            resultMap.setCodeResultDataArrayMsg(200, "success", "成功", houseLayoutLists, houseLayoutLists.size());
        }
        return resultMap;
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value="/queryAllHouseLayout")
    @ResponseBody
    public ResultMap queryAllHouseLayout() {
        ResultMap resultMap = new ResultMap();
        List<HouseLayoutList> houseLayoutLists = houseLayoutService.listAllHouseLayoutList();
        resultMap.setCodeResultDataArrayMsg(200,"success","成功",houseLayoutLists,houseLayoutLists.size());
        return resultMap;
    }

    /**
     * 添加房型
     * @param houseLayoutName
     * @param houseLayoutBed
     * @param houseLayoutPeople
     * @param houseLayoutPeople
     * @return
     */
    @RequestMapping("/addHouseLayout")
    @ResponseBody
    public ResultMap addHouseLayout(@RequestParam(value = "houseLayoutName") String houseLayoutName,
                              @RequestParam(value = "houseLayoutBed") String houseLayoutBed,
                              @RequestParam(value = "houseLayoutPeople") String houseLayoutPeople,
                              @RequestParam(value = "houseLayoutExplanation") String houseLayoutExplanation){
        ResultMap resultMap = new ResultMap();
        HouseLayoutList houseLayoutList = new HouseLayoutList();

        // 房间类型姓名
        houseLayoutList.setHouseLayoutName(houseLayoutName);
        // 房间床数
        houseLayoutList.setHouseLayoutBed(Integer.valueOf(houseLayoutBed));
        // 房间人数
        houseLayoutList.setHouseLayoutPeople(Integer.valueOf(houseLayoutPeople));
        // 房间类型说明
        houseLayoutList.setHouseLayoutExplanation(houseLayoutExplanation);
        int flag = houseLayoutService.insertHouseLayoutList(houseLayoutList);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","添加成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","添加失败");
        }
        return resultMap;
    }

    /**
     * 返回值给前端 数据回显
     * @param houseLayoutId
     * @param model
     * @return
     */
    @RequestMapping("/selectHouseLayoutById")
    public String selectHouseLayoutById(@RequestParam(value = "houseLayoutId") String houseLayoutId, Model model){
        HouseLayoutList houseLayoutList = houseLayoutService.selectHouseLayoutList(Integer.valueOf(houseLayoutId));
        Map<String,Object> map = new HashMap<>();
        model.addAttribute("houseLayoutList",houseLayoutList);
        return "table/editHouseType";
    }

    /**
     * 修改房型
     * @param houseLayoutId
     * @param houseLayoutName
     * @param houseLayoutBed
     * @param houseLayoutPeople
     * @param houseLayoutExplanation
     * @return
     */
    @RequestMapping("/updateHouseLayout")
    @ResponseBody
    public ResultMap updateHouseLayout(@RequestParam(value = "houseLayoutId") String houseLayoutId,
                                       @RequestParam(value = "houseLayoutName") String houseLayoutName,
                                       @RequestParam(value = "houseLayoutBed") String houseLayoutBed,
                                       @RequestParam(value = "houseLayoutPeople") String houseLayoutPeople,
                                       @RequestParam(value = "houseLayoutExplanation") String houseLayoutExplanation){


        ResultMap resultMap = new ResultMap();
        HouseLayoutList houseLayoutList = new HouseLayoutList();
        houseLayoutList.setHouseLayoutId(Integer.valueOf(houseLayoutId));
        // 房间类型姓名
        houseLayoutList.setHouseLayoutName(houseLayoutName);
        // 房间床数
        houseLayoutList.setHouseLayoutBed(Integer.valueOf(houseLayoutBed));
        // 房间人数
        houseLayoutList.setHouseLayoutPeople(Integer.valueOf(houseLayoutPeople));
        // 房间类型说明
        houseLayoutList.setHouseLayoutExplanation(houseLayoutExplanation);
        int flag = houseLayoutService.updateHouseLayoutList(houseLayoutList);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","修改成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","修改失败");
        }
        return resultMap;
    }

    /**
     * 删除
     * @param houseLayoutId
     * @return
     */
    @RequestMapping("deleteHouseLayout")
    @ResponseBody
    public ResultMap deleteHouseLayout(@RequestParam(value = "houseLayoutId") String houseLayoutId){
        int flag = houseLayoutService.deleteHouseLayoutList(Integer.valueOf(houseLayoutId));
        ResultMap resultMap = new ResultMap();
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","删除成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","删除失败");
        }
        return resultMap;
    }
}
