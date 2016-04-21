package com.cafe.web.controller;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.ProductData;
import com.cafe.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/11/2016.
 */
@Controller
@RequestMapping("/productSetup")
public class ProductController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws CafeException {

        Map<String, Object> params = this.parseParameter(request);
        if(getCafeUserDetails() != null){
            params.put("restaurantID", this.getCafeUserDetails().getLoggedInUserdata().getRestaurantID());
        }
        List<ProductData> productList = this.productService.getProductByParam(params);
        return this.buildResultForGrid(productList, productList.size(), params);

    }

    @RequestMapping(value = {"/getProductForTypeHead/data/{data}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ProductData> getAll(@PathVariable("data") String data, HttpServletRequest request) throws CafeException {

        Map<String, Object> params = new HashMap<>();
        params.put("name" , data);
        if(getCafeUserDetails() != null){
            params.put("restaurantID", this.getCafeUserDetails().getLoggedInUserdata().getRestaurantID());
        }
        List<ProductData> productList = this.productService.getProductByParam(params);
        return productList;
    }

    @RequestMapping(value = {"/getAllForSelect"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ProductData> getAllForSelect(HttpServletRequest request) throws CafeException {

        Map<String, Object> params = null;
        List<ProductData> productList = this.productService.getProductByParam(params);
        return productList;

    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ProductData data) throws CafeException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(data)) {
            result.put("success", false);
            result.put("message", "Duplicate Restaurant name exists");
            return result;
        }
        this.productService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ProductData data) throws CafeException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(data)) {
            result.put("success", false);
            result.put("message", "Duplicate Restaurant name exists");
            return result;
        }
        this.productService.update(data);
        return result;
    }

    private boolean isDuplicate(ProductData data) throws CafeException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("productID", data.getProductID());
        param.put("name", data.getName());
        Integer count = this.productService.getDuplicateCount(param);
        return (count != null && count > 0);
    }
}
