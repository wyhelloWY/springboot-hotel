package com.jxau.hotelsystem.pojo.DO;

import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 15:34
 */
@Data
public class HouseList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间id
     */
    private Integer houseId;

    /**
     * 房间编号
     */
    private String houseNumber;

    /**
     * 房间状态
     */
    private Integer houseStatus;

    /**
     * 房间说明
     */
    private String houseExplanation;

    /**
     * 房间价钱
     */
    private Double houseMoney;

    /**
     * 会员价钱
     */
    private Double houseMemberMoney;

    /**
     * 房间类型
     */
    private Integer houseType;

    /**
     * 房间图片
     */
    private String houseImage;

    /**
     * 房源创建时间
     */
    private Date houseDate;

    @Transient
    private String houseTypeByInt;
    public HouseList() {
    }

}
