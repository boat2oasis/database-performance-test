package com.service.mall.exchange.re;

import lombok.Data;

@Data
public class SpendMoneyRe {
	public Integer accountId;
	public Integer necessaryId;
	public String spendAmount;
	public String description;
}
