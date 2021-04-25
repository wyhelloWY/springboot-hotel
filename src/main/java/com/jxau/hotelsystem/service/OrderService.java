package com.jxau.hotelsystem.service;

import com.jxau.hotelsystem.pojo.DO.OrderList;
import com.jxau.hotelsystem.pojo.DO.UserList;
import com.jxau.hotelsystem.utils.PageRequest;
import com.jxau.hotelsystem.utils.PageResult;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 16:23
 */
public interface OrderService {
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
     * 查询单个用户订单
     * @param pageRequest
     * @param id
     * @return
     */
    List<OrderList> getOrderListById(PageRequest pageRequest,int id);
    /**
     * 删除单个订单详情
     * @param orderId
     * @return
     */
    int deleteOrderList(String orderId);
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
    List<OrderList> getOrderList(PageRequest pageRequest);
}
