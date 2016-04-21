package com.cafe;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.RestaurantData;
import com.cafe.service.RestaurantService;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

/**
 * Created by raj on 4/11/2016.
 */
public class CafeTest extends BaseTest {

    RestaurantService restaurantService = applicationContext.getBean(RestaurantService.class);


    public Integer save(String name, Integer useGst, Double gst) throws CafeException{
        RestaurantData restaurantData = new RestaurantData();
        restaurantData.setRestaurantName(name);
        restaurantData.setUseGst(useGst);
        restaurantData.setGstRate(BigDecimal.valueOf(gst));
        restaurantService.create(restaurantData);
        
        return restaurantData.getRestaurantID();
    }
}
