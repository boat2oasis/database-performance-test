package com.service.mall;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.mall.entity.Products;
import com.service.mall.mapper.ProductsMapper;

@SpringBootTest
@MapperScan("com.service.mall.mapper")
public class MallApplicationTests {

	@Autowired
	private ProductsMapper productsMapper;
	@Autowired
	private ExecutorService threadPoolExecutor;

	private Integer totalnum = 0;

	@Test
	public void testSelect() {
		long start = System.currentTimeMillis();

		Runnable runnable = () -> {

			// totalnum++;
			int index = 0;

			List<Products> doList = new ArrayList<>();
			while (true) {
				index++;

				//synchronized (this) {
					totalnum++;
				//}

				if (totalnum > 5000000 && doList.size() == 0) {
					long end = System.currentTimeMillis();
					System.out.println("一共运行的时间是:" + (end - start));
					break;
				}

				if (totalnum > 5000000 && doList.size() > 0) {
					long end = System.currentTimeMillis();
					System.out.println("一共运行的时间是:" + (end - start));
					productsMapper.insertProducts(doList);
					break;
				} else {
					Products products = new Products();
					products.setCategoryId(UUID.randomUUID().toString().replace("-", ""));
					products.setDescription(UUID.randomUUID().toString().replace("-", ""));
					products.setImageUrl(UUID.randomUUID().toString().replace("-", ""));
					products.setPrice(UUID.randomUUID().toString().replace("-", ""));
					products.setProductName(UUID.randomUUID().toString().replace("-", ""));
					products.setStock(10);
					doList.add(products);

					if (index == 5000) {
						productsMapper.insertProducts(doList);
						//System.out.println();
						index = 0;
						doList = new ArrayList<>();
					}
				}
			}
		};
		for (int i = 0; i < 10; i++) {
			threadPoolExecutor.submit(runnable);
		}
		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
