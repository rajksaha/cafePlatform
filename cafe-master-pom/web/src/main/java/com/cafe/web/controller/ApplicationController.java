package com.cafe.web.controller;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.CafeUserDetail;
import com.cafe.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    public Map<String, Object> getAppData(HttpServletRequest request) throws CafeException {

        CafeUserDetail cafeUserDetail = getCafeUserDetails();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("userData", cafeUserDetail.getLoggedInUserdata());
        return result;
    }




}
