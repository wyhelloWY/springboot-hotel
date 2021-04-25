package com.jxau.hotelsystem.service;

import com.jxau.hotelsystem.pojo.DO.HouseList;
import com.jxau.hotelsystem.pojo.DO.OrderList;
import com.jxau.hotelsystem.utils.PageRequest;
import com.jxau.hotelsystem.utils.PageResult;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 15:54
 */
public interface HouseService {
    /**
     * 查询所有房源
     * @return
     */
    List<HouseList> listAllHouseList();

    /**
     * 查询所有房源
     * @return
     */
    List<HouseList> selectPage();

    /**
     * 插入房源
     * @param houseList
     * @return
     */
    int insertHouseList(HouseList houseList);

    /**
     * 修改房源状态
     * @param houseId
     * @return
     */
    int orderHouseList(int houseId,int houseStatus);
    /**
     * 修改状态
     * @param houseNumber
     * @param houseStatus
     * @return
     */
    int updateHouseListByNumber(int houseNumber,int houseStatus);
    /**
     * 修改房源
     * @param houseList
     * @return
     */
    int updateHouseList(HouseList houseList);
    /**
     * 查询房源通过 key
     * @param key
     * @return
     */

    List<HouseList> listAllHouseListByKey(String key);
    /**
     * 删除房源
     * @param houseId
     * @return
     */
    int deleteHouseList(int houseId);
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
    List<HouseList> getHouseList(PageRequest pageRequest);
    /**
     * 查询详情
     * @param houseId
     * @return
     */
    HouseList selectHouseListInfo(int houseId);
}
