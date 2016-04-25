package cafeJunit;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.cafe.BaseTest;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantData;
import com.cafe.service.RestaurantService;

/**
 * * @author Frzia
 * **/
 


public class CafeJunitTester extends BaseTest{
	
	static Integer id = null;
	static String name = "Test cafe";
		
	RestaurantService restaurantService = applicationContext.getBean(RestaurantService.class);

		
	@Test
	public void testCreateCafe() throws CafeException{
         id = this.save(this.name, 1, .05);
    	assertNotNull(id);
	}
	@Test 
	public void getRestaurantByIdTest() throws CafeException{
		
		RestaurantData data = restaurantService.getRestaurantByID(id);
		assertNotNull(data);
		
	}
	@Test
	public void testUpdateCafe() throws CafeException{
		RestaurantData data= restaurantService.getRestaurantByID(id);
		//data.setUseGst(0);
		restaurantService.update(data);
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
	
	 private Integer save(String name, Integer useGst, Double gst) throws CafeException{
	        RestaurantData restaurantData = new RestaurantData();
	        restaurantData.setRestaurantName(name);
	        restaurantData.setUseGst(useGst);
	        restaurantData.setGstRate(BigDecimal.valueOf(gst));
	        restaurantService.create(restaurantData);
	        
	        return restaurantData.getRestaurantID();
	    }
	
	

}
