package com.service.mall.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author anyway
 * @since 2024-06-11
 */
@Getter
@Setter
@TableName("spend_money")
public class SpendMoney implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 记录主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 账户id
	 */
	@TableField("account_id")
	private Integer accountId;

	/**
	 * 记录id
	 */
	@TableField("necessary_id")
	private Integer necessaryId;

	/**
	 * 消费金额
	 */
	@TableField("spend_amount")
	private String spendAmount;

	/**
	 * 消费备注
	 */
	@TableField("description")
	private String description;

	/**
	 * 消费时间
	 */
	@TableField("spend_time")
	private LocalDateTime spendTime;
}
