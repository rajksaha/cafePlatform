package cafeJunit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.BaseTest;
import com.cafe.CafeTest;
import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantData;
import com.cafe.service.RestaurantService;

public class CafeJunitTester extends BaseTest{
	
	static Integer id = null;
	static String name = "Test cafe";
	
	RestaurantService restaurantService = applicationContext.getBean(RestaurantService.class);

	CafeTest cafeTest = new  CafeTest();
	
	@Transactional
	public void testCreateCafe() throws CafeException{
         id = cafeTest.save(name, 1, .05);
    	assertNotNull(id);
	}
	@BeforeTransaction
	public void getCafe() throws CafeException{
		
		RestaurantData data = restaurantService.getRestaurantByID(id);
		assertNotNull(data);
		
	}

	public static Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		CafeJunitTester.id = id;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		CafeJunitTester.name = name;
	}
	
	
	

}
