package com.cafe.web.controller;

import com.cafe.common.exception.BfpbException;
import com.cafe.mybatis.domain.Base;
import com.itextpdf.text.DocumentException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mamun on 1/21/16.
 */
public class BaseController {

    public Object getFamsUserDetails() {
        return (Object) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Object getProfile() {
        return null;
    }

    public Integer getProfileId() {
        return null;
    }


    /**
     * parse HttpServletRequest for pagination
     * @param request HttpServletRequest
     * @return resultMap Map<String, Object>
     */
    public Map<String, Object> parseParameter(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Enumeration names = request.getParameterNames();
        while(names.hasMoreElements()){
            String name = (String) names.nextElement();
            if(StringUtils.isNotEmpty(request.getParameter(name))) {
                resultMap.put(name, request.getParameter(name));
            }
        }

        Integer page = Integer.parseInt((String) resultMap.get("page"));
        Integer limit = Integer.parseInt((String) resultMap.get("limit"));
        String sortColumn = (String) resultMap.get("sort");
        if(StringUtils.isEmpty(sortColumn)) sortColumn = "1";
        String sortOrder = (String) resultMap.get("sort_dir");
        Integer offset = (page - 1) * limit;

        // remove un-necessary param
        resultMap.remove("skip");
        resultMap.remove("page");
        resultMap.remove("sort_dir");
        resultMap.remove("sort");

        //put new params
        resultMap.put("sortColumn", sortColumn);
        resultMap.put("sortOrder", sortOrder);
        resultMap.put("offset", offset);
        resultMap.put("limit", limit);

        return resultMap;
    }

    /**
     * build resultSet for pagination
     * @param list List of data
     * @param count total count of list
     * @return resultMap Map<String, Object>
     */
    public Map<String, Object> buildResultForGrid(List list, Integer count, Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Integer offset = param.get("offset") != null ? Integer.parseInt(param.get("offset").toString()) : 0;
        offset++; // change 0 based to 1 based
        if (CollectionUtils.isNotEmpty(list) && list.get(0) instanceof Base) {
            for (int i = 0; i < list.size(); i++) {
                Base object = (Base) list.get(i);
                object.setSerial(offset);
                offset++;
            }
        }
        resultMap.put("list", list);
        resultMap.put("count", count);
        return resultMap;
    }

    public void exportToExcel(HttpServletResponse response,Workbook wb,String reportName) throws BfpbException, IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.addHeader("Pragma", "No-cache");
        response.addHeader("Cache-control", "no-cache");
        response.addDateHeader("Expires",1 );
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", reportName);
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();
        wb.write(outStream);
        wb.close();

        // close what's open
        outStream.close();
    }

    public void exportToPdf(HttpServletResponse response,ByteArrayOutputStream baos,String reportName) throws BfpbException, IOException, DocumentException {

        response.setContentLength(baos.size());
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        // setting the content type
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", reportName);
        response.setHeader(headerKey, headerValue);


        OutputStream os = response.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();
    }
}
