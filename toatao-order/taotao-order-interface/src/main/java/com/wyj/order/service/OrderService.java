package com.wyj.order.service;

import com.wyj.common.pojo.TaotaoResult;
import com.wyj.order.service.pojo.OrderInfo;

public interface OrderService {
	TaotaoResult createOrder(OrderInfo orderInfo);
}
