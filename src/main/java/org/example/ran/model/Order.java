package org.example.ran.model;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_order")
public class Order {
    private Long orderId;
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

