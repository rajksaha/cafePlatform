package com.cafe.web.controller;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.mybatis.domain.RestaurantTableData;
import com.cafe.service.ProductService;
import com.cafe.service.RestaurentTableService;
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
@RequestMapping("/tableSetup")
public class TableController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(TableController.class);

    @Autowired
    private RestaurentTableService restaurentTableService;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BfpbException {

        Map<String, Object> params = this.parseParameter(request);
        if(getCafeUserDetails() != null){
            params.put("restaurantID", this.getCafeUserDetails().getLoggedInUserdata().getRestaurantID());
        }
        List<RestaurantTableData> restaurantTableDatas = this.restaurentTableService.getRestaurantTableByParam(params);
        return this.buildResultForGrid(restaurantTableDatas, restaurantTableDatas.size(), params);

    }


    @RequestMapping(value = {"/getAllForSelect"}, method = RequestMethod.GET)
    @ResponseBody
    public List<RestaurantTableData> getAllForSelect(HttpServletRequest request) throws BfpbException {

        Map<String, Object> params = new HashMap<String, Object>();
        if(getCafeUserDetails() != null){
            params.put("restaurantID", this.getCafeUserDetails().getLoggedInUserdata().getRestaurantID());
        }

        List<RestaurantTableData> restaurantTableDatas = this.restaurentTableService.getRestaurantTableByParam(params);
        return restaurantTableDatas;

    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody RestaurantTableData data) throws BfpbException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(data)) {
            result.put("success", false);
            result.put("message", "Duplicate Restaurant name exists");
            return result;
        }
        this.restaurentTableService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody RestaurantTableData data) throws BfpbException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(data)) {
            result.put("success", false);
            result.put("message", "Duplicate Restaurant name exists");
            return result;
        }
        this.restaurentTableService.update(data);
        return result;
    }

    private boolean isDuplicate(RestaurantTableData data) throws BfpbException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tableID", data.getTableID());
        param.put("name", data.getName());
        Integer count = this.restaurentTableService.getDuplicateCount(param);
        return (count != null && count > 0);
    }
}
