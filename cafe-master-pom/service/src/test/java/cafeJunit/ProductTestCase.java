package cafeJunit;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.cafe.BaseTest;
import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.service.ProductService;

public class ProductTestCase extends BaseTest{

	
	ProductService productService = applicationContext.getBean(ProductService.class);
	
	@Test
	public void testCreateProduct() throws CafeException{
		ProductData productData = new ProductData();
		productData.setName("Cake");
		productData.setPrice(BigDecimal.valueOf(5.5));
		productData.setRestaurantID(1);
		//productData.setCost(BigDecimal.valueOf(5.5));
		
		try {
			productService.create(productData);
			assertEquals(1, 1);
		} catch (Exception e) {
			fail("Exception");
		}
		
		
	}

}
