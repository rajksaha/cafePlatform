package com.cafe.service;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.Division;
import com.cafe.mybatis.domain.UserGroupPermissionData;
import com.cafe.mybatis.persistence.DivisionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by mamun on 1/13/16.
 */
@Service
public class DivisionService {

    @Autowired
    private DivisionMapper divisionMapper;

    public void create(Division division) throws CafeException {
        this.divisionMapper.create(division);
    }

    public void update(Division division) throws CafeException {
        this.divisionMapper.update(division);
    }

    public List<Division> getDivisionByParam(Map<String, Object> params) throws CafeException {
        return this.divisionMapper.getDivisionByParam(params);
    }

    public Integer getDivisionCountByParam(Map<String, Object> params) throws CafeException {
        return this.divisionMapper.getDivisionCountByParam(params);
    }

    public Division getDivisionByID(Integer divisionId) throws CafeException {
        return this.divisionMapper.getDivisionByID(divisionId);
    }

    public Integer getDuplicateCount(Map<String, Object> params) throws CafeException {
        return this.divisionMapper.getDuplicateCount(params);
    }

    public List<UserGroupPermissionData> getUserPermissionByUserID(Integer userID) throws CafeException {
        return null;
    }
}
