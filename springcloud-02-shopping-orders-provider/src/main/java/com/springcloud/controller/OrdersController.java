package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;

import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * 订单模块的控制层
 * 
 * @author bai
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			// 查询满足条件的商品信息
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders, pageNumber);
			// 从分页信息中获取商品信息
			List<Orders> list = pageInfo.getList();
			// 如果查询到了满足条件的商品信息
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				// 将商品信息已指定的键存入Map集合中
				map.put("ordersList", list);
				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				// 将分页信息以指定的名字存入Map集合中
				map.put("pageUtils", pageUtils);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	@RequestMapping(value = "/updateOrdersStatus")
	public ResultValue updateOrdersStatus(Orders orders) {
		ResultValue rv = new ResultValue();
		try {
			Integer status = this.ordersService.updateOrdersStatus(orders);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("订单状态修改成功！");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("订单状态修改失败！！！");
		return rv;
	}
	/**
	 * 	查询征指定时间范围内的销售额
	 * @param orders	查询条件
	 * @return	成功返回java.utli.List类型的实例，失败返回null
	 */
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders) {
		ResultValue rv = new ResultValue();
		try {
			List<Orders> list = this.ordersService.selectGroup(orders);
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				//创建两个集合，用于保存柱状图X轴和Y轴的数据
				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();
				//将查询结果中的商品名称存入X集合，销量存入Y集合
				for(Orders order : list) {
					x.add(order.getOrderMonth());
					y.add(order.getOrderSum());
				}
				
				Map<String,Object> map = new HashMap<>();
				map.put("x", x);
				map.put("y", y);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
}
