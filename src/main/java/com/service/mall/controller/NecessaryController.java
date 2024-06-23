package com.service.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.mall.annotate.Log;
import com.service.mall.entity.Necessary;
import com.service.mall.result.Result;
import com.service.mall.service.INecessaryService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author anyway
 * @since 2024-06-10
 */
@RestController
@RequestMapping("/necessary")
public class NecessaryController {
	@Autowired
	private INecessaryService necessaryService;
	
	
	@GetMapping("/list")
	@Log
	public Result getAccountList() {
		List<Necessary> necessaryList = necessaryService.list();
		return Result.success(necessaryList);
	}
}
