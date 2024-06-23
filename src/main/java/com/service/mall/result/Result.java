package com.service.mall.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 响应实体类.
 * 
 * @author yuanxh
 * @version 1.0.0 CreateDate 2020年4月30日 下午5:39:17 description
 */
@Getter
@Setter
@ToString
public class Result {

	/**
	 * 结果编码.
	 */
	private int code;

	private int ret;

	/**
	 * 提示信息.
	 */
	private String msg;

	/**
	 * 结果数据.
	 */
	private Object data;

	/**
	 * 默认初始化.
	 */
	public Result() {

	}

	/**
	 * 带参初始化.
	 *
	 * @param code 结果编码
	 * @param msg  提示信息
	 * @param data 返回结果数据
	 */
	public Result(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.ret = code == 0 ? 0 : 1;
	}

	/**
	 * 成功.
	 *
	 * @return 返回结果
	 */
	public static Result success() {
		return new Result(0, "success", null);
	}

	/**
	 * 专门为从app来的数据设置的成功.
	 *
	 * @param code 结果编码
	 * @return 返回结果
	 */
	public static Result success(Integer code) {
		return new Result(code, "success", null);
	}

	/**
	 * 带data成功.
	 *
	 * @param data 返回结果数据
	 * @return 返回结果
	 */
	public static Result success(Object data) {
		return new Result(0, "success", data);
	}

	/**
	 * 带msg和data成功.
	 *
	 * @param data 返回结果数据
	 * @param msg  提示信息
	 * @return 返回结果
	 */
	public static Result success(Object data, String msg) {
		return new Result(0, msg, data);
	}

	/**
	 * 带msg失败.
	 *
	 * @param msg 提示信息
	 * @return 返回结果
	 */
	public static Result failure(String msg) {
		return new Result(-1, msg, null);
	}

	/**
	 * 带data失败.
	 *
	 * @param data 返回结果数据
	 * @return 返回结果
	 */
	public static Result failure(Object data) {
		return new Result(-1, "请求失败", data);
	}

	/**
	 * 带code和msg失败.
	 *
	 * @param code 结果编码
	 * @param msg  提示信息
	 * @return 返回结果
	 */
	public static Result failure(int code, String msg) {
		return new Result(code, msg, null);
	}

}
