package com.wyj.order.service.pojo;

import java.io.Serializable;
import java.util.List;

import com.wyj.pojo.TbOrderItem;
import com.wyj.pojo.TbOrderShipping;

import com.wyj.pojo.TbOrder;

public class OrderInfo extends TbOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 商品列表
    private List<TbOrderItem> orderItems;
    // 收货地址
    private TbOrderShipping orderShipping;
    public List<TbOrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<TbOrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public TbOrderShipping getOrderShipping() {
        return orderShipping;
    }
    public void setOrderShipping(TbOrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }

}
