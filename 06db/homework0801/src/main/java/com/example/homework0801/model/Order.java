package com.example.homework0801.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * Order
 *
 * @author zengqi
 * @date 2021/8/9 17:13
 */

@Data
@TableName("t_order")
public class Order {
    @TableId
    @TableField("order_id")
    private Long orderId;
    @TableField("user_id")
    private Long userId;
    private String status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
