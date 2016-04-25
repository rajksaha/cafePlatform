package cafeJunit;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.BaseTest;
import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.service.ProductService;

public class ProductTestCase extends BaseTest{

	
	/*static Integer id = null;
	ProductService productService = applicationContext.getBean(ProductService.class);
	
	@Test
	public void testCreateProduct() throws CafeException{
		ProductData productData = new ProductData();
		productData.setName("Cake");
		productData.setPrice(BigDecimal.valueOf(5.5));
		productData.setRestaurantID(1);
		productData.setCost(BigDecimal.valueOf(5.5));
		
		try {
			productService.create(productData);
			
			id = productData.getProductID();
			assertNotNull(id);
		} catch (Exception e) {
			fail("Exception");
		}
		
		
	}
	
	@Test
	public void deteteProduct() throws CafeException {
		Map<String,Object> param = new HashMap<>();
		param.put("productID", id);
		productService.delete(param);
	}*/

}
