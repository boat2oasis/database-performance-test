package com.service.mall.mapper;

import com.service.mall.entity.Products;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author anyway
 * @since 2024-05-29
 */
@Repository
public interface ProductsMapper extends BaseMapper<Products> {
	void insertProducts(@Param("products") List<Products> products);
}
