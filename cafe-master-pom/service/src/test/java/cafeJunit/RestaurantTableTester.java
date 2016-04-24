package cafeJunit;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.BaseTest;
import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantTableData;
import com.cafe.service.RestaurentTableService;

public class RestaurantTableTester extends BaseTest {
	
	static Integer id = null;
	
	RestaurentTableService tableService = applicationContext.getBean(RestaurentTableService.class);
	
	@Test
	public void testCreateTable() throws CafeException{
		
		RestaurantTableData data = new RestaurantTableData();
		data.setRestaurantID(1);
		data.setLevel(1);
		data.setName("abc");
		data.setCommentOrder("order taken");
		
		tableService.create(data);
		
		id = data.getTableID();
		assertNotNull(id);
		
	}
	
	@Test
	public void testUpdateTable() throws CafeException{
		
		RestaurantTableData data = tableService.getRestaurantTableByID(id);
		assertNotNull(data);
	}
	
	@Test
	public void deteteTable() throws CafeException {
		Map<String,Object> param = new HashMap<>();
		param.put("tableID", id);
		tableService.delete(param);
	}
	
	

}
