package com.springcloud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.dao.OrderDetailsMapper;
import com.springcloud.entity.OrderDetails;
import com.springcloud.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	private OrderDetailsMapper orderDetailsMapper;

	@Override
	public PageInfo<OrderDetails> selectByOrderId(Integer orderId, Integer pageNumber) {

		// 设置每页的信息
		PageHelper.startPage(pageNumber + 1, PageUtils.PAGE_ROW_COUNT);
		// 查询指定编号的订单明细的信息
		List<OrderDetails> list = this.orderDetailsMapper.selectByOrderId(orderId);
		// 返回分页信息
		return new PageInfo<>(list);
	}

}
