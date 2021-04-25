package com.jxau.hotelsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxau.hotelsystem.dao.OrderDao;
import com.jxau.hotelsystem.pojo.DO.HouseList;
import com.jxau.hotelsystem.pojo.DO.OrderList;
import com.jxau.hotelsystem.service.OrderService;
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
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrderList> selectPage() {
        return orderDao.selectPage();
    }

    @Override
    public List<OrderList> selectByOrderPeopleId(int orderPeopleId) {
        return orderDao.selectByOrderPeopleId(orderPeopleId);
    }

    @Override
    public int insertOrderList(OrderList orderList) {
        return orderDao.insertOrderList(orderList);
    }

    @Override
    public int updateOrderList(OrderList orderList) {
        return orderDao.updateOrderList(orderList);
    }

    @Override
    public OrderList selectOrderList(String orderId) {
        return orderDao.selectOrderList(orderId);
    }

    @Override
    public int deleteOrderList(String orderId) {
        return orderDao.deleteOrderList(orderId);
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
        List<OrderList> sysMenus = orderDao.selectPage();
        return new PageInfo<OrderList>(sysMenus);
    }

    private PageInfo<?> getOrderListByIdInfo(PageRequest pageRequest,int id) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<OrderList> sysMenus = orderDao.selectByOrderPeopleId(id);
        return new PageInfo<OrderList>(sysMenus);
    }
    @Override
    public List<OrderList> getOrderListById(PageRequest pageRequest,int id) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<OrderList> sysMenus = orderDao.selectByOrderPeopleId(id);
        return sysMenus;
    }
    @Override
    public List<OrderList> getOrderList(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<OrderList> sysMenus = orderDao.selectPage();
        return sysMenus;
    }
}
