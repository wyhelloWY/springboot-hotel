package com.jxau.hotelsystem.controller;

import com.jxau.hotelsystem.annotation.MyLog;
import com.jxau.hotelsystem.pojo.DO.HouseList;
import com.jxau.hotelsystem.pojo.DO.OrderList;
import com.jxau.hotelsystem.pojo.DO.UserList;
import com.jxau.hotelsystem.pojo.ResultMap;
import com.jxau.hotelsystem.service.HouseService;
import com.jxau.hotelsystem.service.OrderService;
import com.jxau.hotelsystem.utils.GetDateUtil;
import com.jxau.hotelsystem.utils.KeyUtil;
import com.jxau.hotelsystem.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 17:33
 */
@Controller
@RequestMapping("/orderApi")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HouseService houseService;
    /**
     * 分页查询
     * @param num
     * @param size
     * @return
     */
    @RequestMapping(value="/findOrderPage")
    @ResponseBody
    @MyLog(value = "查询分页订单")
    public ResultMap findOrderPage(@RequestParam(value = "page",required = false) int num,
                                   @RequestParam(value = "limit",required = false)int size) {
        ResultMap resultMap = new ResultMap();
        List<OrderList> orderLists = new ArrayList<>();
        PageRequest pageQuery = new PageRequest();
        pageQuery.setPageNum(num);
        pageQuery.setPageSize(size);
        orderLists = orderService.getOrderList(pageQuery);
        resultMap.setCodeResultDataArrayMsg(200,"success","成功",orderLists,orderLists.size());
        return resultMap;
    }

    /**
     * 查询某个用户的订单
     * @return
     */
    @RequestMapping(value="/findOrderById")
    @ResponseBody
    @MyLog("查询订单")
    public ResultMap findOrderById(HttpSession httpSession,
                                   @RequestParam(value = "page",required = false) int num,
                                   @RequestParam(value = "limit",required = false)int size) {
        UserList userList = (UserList) httpSession.getAttribute("userList");
        ResultMap resultMap = new ResultMap();
        List<OrderList> orderLists = new ArrayList<>();
        PageRequest pageQuery = new PageRequest();
        pageQuery.setPageNum(num);
        pageQuery.setPageSize(size);
        orderLists = orderService.getOrderListById(pageQuery,userList.getUserId());
        resultMap.setCodeResultDataArrayMsg(200,"success","成功",orderLists,orderLists.size());
        return resultMap;
    }

    /**
     * 添加订单
     * @param orderHouseId
     * @param orderStartDate
     * @param orderEndDate
     * @param orderPeopleNumber
     * @param httpSession
     * @return
     */
    @RequestMapping(value="/addOrder")
    @ResponseBody
    public ResultMap addOrder(@RequestParam(value = "orderHouseId") String orderHouseId,
                              @RequestParam(value = "orderStartDate") String orderStartDate,
                              @RequestParam(value = "orderEndDate") String orderEndDate,
                              @RequestParam(value = "orderPeopleNumber") String orderPeopleNumber,
                              HttpSession httpSession) {
        ResultMap resultMap = new ResultMap();
        UserList userList = (UserList) httpSession.getAttribute("userList");
        HouseList houseList = houseService.selectHouseListInfo(Integer.valueOf(orderHouseId));
        OrderList orderList = new OrderList();
        // 订单id
        orderList.setOrderId(KeyUtil.generateUniqueKey());
        // 订单创建人
        orderList.setOrderPeopleId(userList.getUserId());
        // 预定房间号
        orderList.setOrderHouseId(Integer.valueOf(houseList.getHouseNumber()));
        // 预定时间
        orderList.setOrderDate(GetDateUtil.getDateTime());
        // 入住时间
        orderList.setOrderStartDate(GetDateUtil.stringToDate(orderStartDate));
        // 结束时间
        orderList.setOrderEndDate(GetDateUtil.stringToDate(orderEndDate));
        // 入住人数
        orderList.setOrderPeopleNumber(Integer.valueOf(orderPeopleNumber));
        // order_type
        orderList.setOrderType(1);
        int flag = orderService.insertOrderList(orderList);
        if(flag > 0){
            houseService.orderHouseList(Integer.valueOf(orderHouseId),Integer.valueOf(1));
            resultMap.setCodeResultMsg(200,"success","添加成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","添加失败");
        }
        return resultMap;
    }

    /**
     * 审核订单
     */
    @RequestMapping(value="/checkOrder")
    @ResponseBody
    public ResultMap checkOrder(@RequestParam(value = "orderId") String orderId,
                              @RequestParam(value = "orderType") String orderType){
        OrderList orderList = orderService.selectOrderList(orderId);
        orderList.setOrderType(Integer.valueOf(orderType));
        ResultMap resultMap = new ResultMap();
        int flag = orderService.updateOrderList(orderList);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","审核成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","审核失败");
        }
        return resultMap;
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @RequestMapping(value="/deleteOrder")
    @ResponseBody
    public ResultMap deleteOrder(@RequestParam(value = "orderId") String orderId){
        ResultMap resultMap = new ResultMap();
        int flag = orderService.deleteOrderList(orderId);
        if(flag > 0){
            resultMap.setCodeResultMsg(200,"success","删除成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","删除失败");
        }
        return resultMap;
    }
    /**
     * 退订订单 1预定  2  退订   3 已支付
     */
    @RequestMapping(value="/updateOrder")
    @ResponseBody
    public ResultMap updateOrder(@RequestParam(value = "orderId") String orderId){
        OrderList orderList = orderService.selectOrderList(orderId);
        ResultMap resultMap = new ResultMap();
        orderList.setOrderType(2);
        int flag = orderService.updateOrderList(orderList);
        if(flag > 0){
            int x = houseService.updateHouseListByNumber(orderList.getOrderHouseId(),0);
            resultMap.setCodeResultMsg(200,"success","退订成功");
        }else{
            resultMap.setCodeResultMsg(200,"error","退订失败");
        }
        return resultMap;
    }
}
