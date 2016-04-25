package cafeJunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cafe.common.exception.CafeException;

@RunWith(Suite.class)
@SuiteClasses({ UserJunit.class, ProductTestCase.class , CafeJunitTester.class, RestaurantTableTester.class})
public class AllTests {

	
}
