package com.cafe.web.controller;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.MainOrderData;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.service.MainOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raj on 4/21/2016.
 */

@Controller
@RequestMapping("/orderController")
public class OrderController extends BaseController{

    @Autowired
    private MainOrderService mainOrderService;

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody MainOrderData data) throws BfpbException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        data.setUserID(this.getCafeUserDetails().getLoggedInUserdata().getUserID());
        data.setRestaurantID(this.getCafeUserDetails().getLoggedInUserdata().getRestaurantID());
        this.mainOrderService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody MainOrderData data) throws BfpbException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.mainOrderService.update(data);
        return result;
    }
}
