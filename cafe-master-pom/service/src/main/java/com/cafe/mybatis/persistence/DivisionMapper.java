package com.cafe.mybatis.persistence;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.Division;

import java.util.List;
import java.util.Map;

public interface DivisionMapper {

    void create(Division division) throws BfpbException;

    void update(Division division) throws BfpbException;

    List<Division> getDivisionByParam(Map<String, Object> params) throws BfpbException;

    Integer getDivisionCountByParam(Map<String, Object> params) throws BfpbException;

    Division getDivisionByID(Integer divisionId) throws BfpbException;

    Integer getDuplicateCount(Map<String, Object> params) throws BfpbException;
}
