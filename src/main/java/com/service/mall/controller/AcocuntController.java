package com.service.mall.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.service.mall.annotate.Log;
import com.service.mall.entity.Acocunt;
import com.service.mall.mq.sender.RabbitMQSender;
import com.service.mall.result.Result;
import com.service.mall.service.IAcocuntService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author anyway
 * @since 2024-06-09
 */
@RestController
@RequestMapping("/acocunt")
public class AcocuntController {
	@Autowired
	private IAcocuntService acocuntService;
	
	@Autowired
	private RabbitMQSender rabbitTemplate;
	
	
	@GetMapping("/list")
	@Log
	public Result getAccountList(@RequestParam String routingKey) {
		//List<Acocunt> accountList = acocuntService.list();
		rabbitTemplate.send("without love,i am just a mouse in the sewer",routingKey);
		return Result.success();
	}
	
	@GetMapping("/pay/list")
	@Log
	public Result getPayAccountList() {
		LambdaQueryWrapper<Acocunt> queryWrapper = new LambdaQueryWrapper<Acocunt>();
		queryWrapper.eq(Acocunt::getCouldPay,1);
		List<Acocunt> accountList = acocuntService.list(queryWrapper);
		return Result.success(accountList);
	}
}
