package com.cafe.web.controller;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.RestaurantData;
import com.cafe.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/11/2016.
 */
@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public List<RestaurantData> getAll(HttpServletRequest request) throws BfpbException {

        return this.restaurantService.getRestaurantByParam(null);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody RestaurantData data) throws BfpbException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(data)) {
            result.put("success", false);
            result.put("message", "Duplicate Restaurant name exists");
            return result;
        }
        this.restaurantService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody RestaurantData data) throws BfpbException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(data)) {
            result.put("success", false);
            result.put("message", "Duplicate Restaurant name exists");
            return result;
        }
        this.restaurantService.update(data);
        return result;
    }

    private boolean isDuplicate(RestaurantData data) throws BfpbException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("restaurantID", data.getRestaurantID());
        param.put("restaurantName", data.getRestaurantName());
        Integer count = this.restaurantService.getDuplicateCount(param);
        return (count != null && count > 0);
    }
}
