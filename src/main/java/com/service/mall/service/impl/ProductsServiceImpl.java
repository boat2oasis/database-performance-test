package com.service.mall.service.impl;

import com.service.mall.entity.Products;
import com.service.mall.mapper.ProductsMapper;
import com.service.mall.service.IProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anyway
 * @since 2024-05-29
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements IProductsService {

}
