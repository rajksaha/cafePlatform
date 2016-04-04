package com.cafe.service;

import com.cafe.BaseTest;
import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.Division;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mamun on 2/16/16.
 */
public class DivisionTest extends BaseTest {

    DivisionService divisionService = applicationContext.getBean(DivisionService.class);

    @Ignore
    @Test
    public void getAllTest() throws BfpbException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("divisionName", "t");
        List<Division> divisions = divisionService.getDivisionByParam(params);
        System.out.println(divisions.size());
    }

}
