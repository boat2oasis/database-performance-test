package com.service.mall.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.mall.annotate.Log;
import com.service.mall.exchange.re.SpendMoneyRe;
import com.service.mall.result.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author anyway
 * @since 2024-06-11
 */
@RestController
@RequestMapping("/spendMoney")
public class SpendMoneyController {
	
	@PostMapping("/save")
	@Log
	public Result saveSpendInfo(@RequestBody SpendMoneyRe spendMoneyRe) {
		System.out.println(spendMoneyRe);
		return Result.success();
	}
}
