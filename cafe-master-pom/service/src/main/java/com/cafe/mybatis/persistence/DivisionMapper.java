package com.cafe.mybatis.persistence;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.Division;

import java.util.List;
import java.util.Map;

public interface DivisionMapper {

    void create(Division division) throws CafeException;

    void update(Division division) throws CafeException;

    List<Division> getDivisionByParam(Map<String, Object> params) throws CafeException;

    Integer getDivisionCountByParam(Map<String, Object> params) throws CafeException;

    Division getDivisionByID(Integer divisionId) throws CafeException;

    Integer getDuplicateCount(Map<String, Object> params) throws CafeException;
}
