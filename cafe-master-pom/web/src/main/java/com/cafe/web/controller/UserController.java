package com.cafe.web.controller;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.UserData;
import com.cafe.service.UserService;
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
@RequestMapping("/userSetup")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public List<UserData> getAll(HttpServletRequest request) throws CafeException {

        Map<String, Object> params = null;
        return this.userService.getUserByParam(params);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody UserData data) throws CafeException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(data)) {
            result.put("success", false);
            result.put("message", "Duplicate Restaurant name exists");
            return result;
        }
        this.userService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody UserData data) throws CafeException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(data)) {
            result.put("success", false);
            result.put("message", "Duplicate Restaurant name exists");
            return result;
        }
        this.userService.update(data);
        return result;
    }

    private boolean isDuplicate(UserData data) throws CafeException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userID", data.getUserID());
        param.put("userName", data.getUsername());
        Integer count = this.userService.getDuplicateCount(param);
        return (count != null && count > 0);
    }
}
