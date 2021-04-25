package com.jxau.hotelsystem.dao;

import com.jxau.hotelsystem.pojo.DO.OrderList;
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
public interface OrderDao {
    /**
     * 查询所有订单
     * @return
     */
    List<OrderList> selectPage();

    /**
     * 查询某位用户的所有订单
     * @param orderPeopleId
     * @return
     */
    List<OrderList> selectByOrderPeopleId(int orderPeopleId);

    /**
     * 插入单个订单详情
     * @param orderList
     * @return
     */
    int insertOrderList(OrderList orderList);

    /**
     * 修改订单详情
     * @param orderList
     * @return
     */
    int updateOrderList(OrderList orderList);

    /**
     * 查询单个订单详情
     * @param orderId
     * @return
     */
    OrderList selectOrderList(String orderId);

    /**
     * 删除单个订单详情
     * @param orderId
     * @return
     */
    int deleteOrderList(String orderId);


}
