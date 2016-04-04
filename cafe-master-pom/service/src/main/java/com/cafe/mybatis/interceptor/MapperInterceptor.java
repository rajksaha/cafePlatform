package com.cafe.mybatis.interceptor;

import com.cafe.common.audit.Auditable;
import com.cafe.common.exception.BfpbException;
import com.cafe.context.AppContextManager;
import com.cafe.mybatis.domain.Audit;
import com.cafe.mybatis.domain.Base;
import com.cafe.common.utility.JsonConverter;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

/**
 * Created by mamun on 1/24/16.
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class MapperInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(MapperInterceptor.class);

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }

    public Object intercept(Invocation invocation) throws Throwable {
        Object proceedObj = invocation.proceed();
        this.handleAudit(invocation.getArgs());
        return proceedObj;
    }

    private void handleAudit(Object[] args) {
        MappedStatement stmt = null;
        Object paramObj = null;
        try {
            stmt = (MappedStatement) args[0];
            paramObj = args[1];
            if (!isAuditable(paramObj)) {
                return;
            }
            Auditable auditData = (Auditable) paramObj;
            this.createAudit(stmt, auditData);
        } catch (Exception ex) {
            log.error("Error creating audit " + (stmt != null ? ("for statement: " + stmt.getId()) : ""), ex);
        }
    }

    private void createAudit(MappedStatement stmt, Auditable auditData) throws BfpbException {
        Audit audit = new Audit();
        String jsonValue = JsonConverter.convertObjectToJson(auditData);

        audit.setEntityName(auditData.getEntityName());
        audit.setEntityId(auditData.getEntityId());
        audit.setAuditType(stmt.getSqlCommandType().name());
        audit.setAuditValue(jsonValue);
        audit.setQueryName(stmt.getId());
        audit.setPerformedBy(0); // TODO: set user id
        audit.setPerformedOn(new Timestamp(new Date().getTime()));

        ApplicationContext applicationContext = AppContextManager.getAppContext();
        /*AuditMapper auditMapper = applicationContext.getBean(AuditMapper.class);
        auditMapper.create(audit);*/
    }

    private boolean isAuditable(Object paramObj) {
        if (!(paramObj instanceof Auditable)) {
            return false;
        }
        if (paramObj instanceof Base) {
            if (((Base) paramObj).getSkipAudit() != null && ((Base) paramObj).getSkipAudit()) {
                return false;
            }
        }

        return true;
    }
}
