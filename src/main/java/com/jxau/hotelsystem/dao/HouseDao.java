package com.jxau.hotelsystem.dao;

import com.jxau.hotelsystem.pojo.DO.HouseList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName HouseDao
 * @Description:
 * @date 2021/2/8 15:37
 */
@Mapper
public interface HouseDao {
    /**
     * 查询所有房源
     * @return
     */
    List<HouseList> listAllHouseList();

    /**
     * 查询房源通过 key
     * @param key
     * @return
     */

    List<HouseList> listAllHouseListByKey(String key);
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
     * @param houseStatus
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
     * 删除房源
     * @param houseId
     * @return
     */
    int deleteHouseList(int houseId);

    /**
     * 查询详情
     * @param houseId
     * @return
     */
    HouseList selectHouseListInfo(int houseId);

}
