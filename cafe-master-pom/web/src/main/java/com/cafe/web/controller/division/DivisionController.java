package com.cafe.web.controller.division;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.Division;
import com.cafe.mybatis.domain.UserGroupPermissionData;
import com.cafe.service.DivisionService;
import com.cafe.service.UserPermissionService;
import com.cafe.web.controller.BaseController;
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
 * Created by raj on 1/13/16.
 */
@Controller
@RequestMapping("/division")
public class DivisionController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(DivisionController.class);

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private UserPermissionService userPermissionService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BfpbException {
        Map<String, Object> params = this.parseParameter(request);
        /*List<Division> divisions = this.divisionService.getDivisionByParam(params);
        Integer count = this.divisionService.getDivisionCountByParam(params);*/

        /*List<UserGroupPermissionData> userGroupPermissionDataList = divisionService.getUserPermissionByUserID(2);*/
        return null;
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody Division division) throws BfpbException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(division)) {
            result.put("success", false);
            result.put("message", "Duplicate division name exists");
            return result;
        }
        this.divisionService.create(division);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody Division division) throws BfpbException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(isDuplicate(division)) {
            result.put("success", false);
            result.put("message", "Duplicate division name exists");
            return result;
        }
        this.divisionService.update(division);
        return result;
    }

    private boolean isDuplicate(Division division) throws BfpbException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("divisionId", division.getDivisionId());
        param.put("divisionName", division.getDivisionName());
        Integer count = this.divisionService.getDuplicateCount(param);
        return (count != null && count > 0);
    }

}
