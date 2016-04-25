package cafeJunit;


import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cafe.BaseTest;
import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.UserData;
import com.cafe.service.UserService;

public class UserJunit extends BaseTest{
	
	/*UserService userService = applicationContext.getBean(UserService.class);
	
	static String userName = "honeySing1";
	static String password = "honeySing1";
	static Integer id;
	
	@Test
	public void addUser()throws CafeException{
		
		UserData userData = new UserData();
		userData.setRestaurantID(1);
		userData.setName("Honey Sing");
		userData.setUsername(userName);
		userData.setPassword(password);
		userData.setLevel(2);
		userService.create(userData);
		id = userData.getUserID();
		assertNotNull(id);
		
	}
	
	@Ignore
	@Test
	public void userLoginTest()throws CafeException{
		
		UserData userData = userService.getUserByUserName(userName);
		assertNotNull(userData);
		
	}
	
	@Ignore
	@Test
	public void deteteUser() throws CafeException {
		Map<String,Object> param = new HashMap<>();
		param.put("userID", id);
		userService.delete(param);
	}*/
	

}
