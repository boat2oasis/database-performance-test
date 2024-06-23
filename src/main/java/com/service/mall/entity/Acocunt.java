package com.service.mall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author anyway
 * @since 2024-06-09
 */
@Getter
@Setter
@TableName("acocunt")
public class Acocunt implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private Integer id;

    /**
     * 账户名称
     */
    @TableField("account_name")
    private String accountName;

    /**
     * 账户金额
     */
    @TableField("account_amount")
    private String accountAmount;

    /**
     * 支付icon
     */
    @TableField("account_icon")
    private String accountIcon;

    /**
     * 是否可支付【1:可以支付，0.不可以支付】
     */
    @TableField("could_pay")
    private Byte couldPay;
}
