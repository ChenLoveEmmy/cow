package com.alan.cow.controller;

import com.alan.cow.enums.RetEnum;
import com.alan.cow.util.ExcelTool;
import com.alan.cow.util.JsonBizTool;
import com.alan.cow.vo.Entity;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.*;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "checkPerson";
    }

    @RequestMapping(value = "/index")
    public String mainFrame() {
        return "/mainFrame";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "index";
    }

}
