package com.jxau.hotelsystem.pojo.DO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Yu W
 * @version V1.0
 * @ClassName
 * @Description:
 * @date 2021/2/8 15:32
 */
@Data
public class OrderList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单创建人
     */
    private Integer orderPeopleId;

    /**
     * 预定房间号
     */
    private Integer orderHouseId;

    /**
     * 预定时间
     */
    private Date orderDate;

    /**
     * 入住时间
     */
    private Date orderStartDate;

    /**
     * 结束时间
     */
    private Date orderEndDate;

    /**
     * 入住人数
     */
    private Integer orderPeopleNumber;

    /**
     * order_type
     */
    private Integer orderType;

    public OrderList() {
    }

}

