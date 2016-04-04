package com.cafe.web.controller;

import com.cafe.common.exception.BfpbException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Controller
public class ApplicationController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping(value = {"/application/data"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAppData(HttpServletRequest request) throws BfpbException {

        Map<String, Object> result = new HashMap<String, Object>();



        return result;
    }


}
