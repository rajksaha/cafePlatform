package com.cafe.web.controller;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.MainOrderData;
import com.cafe.mybatis.domain.SearchData;
import com.cafe.service.MainOrderService;
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
 * Created by raj on 4/21/2016.
 */

@Controller
@RequestMapping("/orderController")
public class OrderController extends BaseController{

    @Autowired
    private MainOrderService mainOrderService;

    @RequestMapping(value = {"/getOrderReport"}, method = RequestMethod.POST)
    @ResponseBody
    public List<MainOrderData> getOrderReport(@RequestBody SearchData searchData, HttpServletRequest request) throws CafeException {

        Map<String, Object> param = new HashMap<>();
        param.put("restaurantID", this.getCafeUserDetails().getLoggedInUserdata().getRestaurantID());
        param.put("startDate", searchData.getEntityStartDate());
        param.put("endDate", searchData.getEntityEndDate());
        if(searchData.getEntityType() != null ){
            if(searchData.getEntityType().equalsIgnoreCase("USER")){
                param.put("userID", searchData.getEntityID());
            }
        }
        List<MainOrderData> mainOrderList = this.mainOrderService.getMainOrderByParam(param);

        return mainOrderList;
    }


    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody MainOrderData data) throws CafeException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        data.setUserID(this.getCafeUserDetails().getLoggedInUserdata().getUserID());
        data.setRestaurantID(this.getCafeUserDetails().getLoggedInUserdata().getRestaurantID());
        this.mainOrderService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody MainOrderData data) throws CafeException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.mainOrderService.update(data);
        return result;
    }
}
