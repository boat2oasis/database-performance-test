package com.service.mall.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.mall.result.Result;

@RestController
@RequestMapping("/acocunt")
public class TimeController {
	@GetMapping("/days")
	public Result getDaysByMouth() {
		List<List<String>> resultList = new ArrayList<List<String>>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int month = calendar.get(Calendar.MONTH);

		List<String> dates = new ArrayList<>();
		int foreachCount = 0;
		int days = 0;
		while (calendar.get(Calendar.MONTH) == month) {
			days++;
			foreachCount++;
			if (foreachCount <= 7) {
				dates.add(days+"");

			} else {
				foreachCount = 1;
				resultList.add(dates);
				dates = new ArrayList<>();
				dates.add(days+"");
			}
			calendar.add(Calendar.DATE, 1); // 增加一天
		}
		if (dates.size() > 0) {
            for(int i=0;i<7-dates.size();i++) {
            	dates.add("");
			}
			resultList.add(dates);
		}
		System.out.println("HELLO WORLD");
		Map<String,Object> resutMap = new HashMap<>();
		resutMap.put("month", calendar.get(Calendar.YEAR)+"年"+(month+1)+"月");
		resutMap.put("resultList",resultList);
		return Result.success(resutMap);
	}

}
