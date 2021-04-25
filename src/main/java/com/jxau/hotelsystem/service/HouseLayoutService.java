package com.jxau.hotelsystem.service;

import com.jxau.hotelsystem.pojo.DO.HouseLayoutList;
import com.jxau.hotelsystem.pojo.DO.OrderList;
import com.jxau.hotelsystem.utils.PageRequest;
import com.jxau.hotelsystem.utils.PageResult;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 16:24
 */
public interface HouseLayoutService {
    /**
     * 查询所有房型
     * @return
     */
    List<HouseLayoutList> listAllHouseLayoutList();

    /**
     * 查询所有房型
     * @return
     */
    List<HouseLayoutList> selectPage();

    /**
     * 插入房型
     * @param houseLayoutList
     * @return
     */
    int insertHouseLayoutList(HouseLayoutList houseLayoutList);
    /**
     * 修改房源
     * @param houseLayoutList
     * @return
     */
    int updateHouseLayoutList(HouseLayoutList houseLayoutList);

    /**
     * 删除房源
     * @param houseLayoutId
     * @return
     */
    int deleteHouseLayoutList(int houseLayoutId);
    /**
     * 查询单个房型号
     * @param houseLayoutId
     * @return
     */
    HouseLayoutList selectHouseLayoutList(int houseLayoutId);

    /**
     * 查询key
     * @param key
     * @return
     */
    List<HouseLayoutList> listAllHouseLayoutByKey(String key);
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
    List<HouseLayoutList> getHouseLayoutList(PageRequest pageRequest);
}
