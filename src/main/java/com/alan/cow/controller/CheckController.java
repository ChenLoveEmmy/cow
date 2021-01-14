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

/**
 * @desc：随机抽取
 * @author: Alan
 * @creat：2021/1/9 23:34
 * @version: v1.0.1
 */
@Controller
@RequestMapping(value = "checkController")
public class CheckController {


    @RequestMapping(value = "/checkExcel")
    @ResponseBody
    public String checkExcel(MultipartHttpServletRequest request) {

        try {
            Map<Integer, List<Entity>> allExcelMap = new HashMap<>();
            MultipartFile caseFile = request.getFile("caseFile");
            XSSFWorkbook wb = new XSSFWorkbook(caseFile.getInputStream());
            int sheetCount = wb.getNumberOfSheets();
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                List<Entity> entityList = new ArrayList<>();
                Sheet sheet = wb.getSheetAt(i);
                for(int j= 1;j<=sheet.getLastRowNum();j++){
                    Row row = sheet.getRow(j);
                    Entity entity = new Entity();
                    entity.setName(ExcelTool.getCellFormatValue(row.getCell(0)).trim());
                    entity.setSpecialty(ExcelTool.getCellFormatValue(row.getCell(1)).trim());
                    entity.setPhone(ExcelTool.getCellFormatValue(row.getCell(2)).trim());
                    entity.setAdds(ExcelTool.getCellFormatValue(row.getCell(3)).trim());
                    entity.setRemark(ExcelTool.getCellFormatValue(row.getCell(4)).trim());
                    entityList.add(entity);
                }
                allExcelMap.put(i, entityList);
            }

            List<Entity> checkedEntity = new ArrayList<>();
            for (Integer i: allExcelMap.keySet()) {
                if (allExcelMap.get(i).size() == 0) {
                    continue;
                }
                Random random = new Random();
                int n = random.nextInt(allExcelMap.get(i).size());
                checkedEntity.add(allExcelMap.get(i).get(n));
            }

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("entityList", checkedEntity);
            System.out.println("OK");
            return JsonBizTool.genJson(RetEnum.SUCCESS, resultMap);

        }catch (Exception e) {
            e.printStackTrace();
            return JsonBizTool.genJson("-1", "失败，请检查文件格式是否正确，是否有空行");
        }

    }
}
