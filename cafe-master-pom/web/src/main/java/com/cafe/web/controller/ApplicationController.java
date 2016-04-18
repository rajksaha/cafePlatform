package com.cafe.web.controller;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.CafeUserDetail;
import com.cafe.mybatis.domain.UserData;
import com.cafe.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handles requests for the application initial context datas.
 */

/**
 * Created by raj on 3/20/2016.
 */
@Controller
public class ApplicationController extends BaseController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping(value = {"/application/data"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAppData(HttpServletRequest request) throws BfpbException {

        CafeUserDetail cafeUserDetail = getCafeUserDetails();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("userData", cafeUserDetail.getLoggedInUserdata());
        return result;
    }

    @RequestMapping(value = {"/application/checkAuthentication/username/{username}/password/{password}"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> checkAuthentication(@PathVariable("username") String username, @PathVariable("password") String password,HttpServletRequest request) throws BfpbException {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("username", username);

        List<UserData> userDataList = this.userService.getUserByParam(result);

        result.clear();
        if(CollectionUtils.isNotEmpty(userDataList)){
            UserData userData = userDataList.get(0);
            if(userData.getPassword().equals(password)){
                //CafeUserDetail cafeUserDetail = new CafeUserDetail();
                //cafeUserDetail.setLoggedInUserdata(userData);
                result.put("status", true);
            }else{
                result.put("status", false);
                result.put("message", "Password Is Now Correct");
            }
        }else{
            result.put("status", false);
            result.put("message", "Username does not exist");
        }
        return result;
    }


}
