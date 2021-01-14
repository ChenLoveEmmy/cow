package com.alan.cow.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.SimpleDateFormat;

public class ExcelTool {
	
	@SuppressWarnings("deprecation")
	public static String getCellFormatValue(Cell cell) {
		String cellvalue = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {// 判断单元格是否属于日期格式
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(cell.getDateCellValue()); // java.util.Date类型
				} else {
					String longVal = Math.round(cell.getNumericCellValue())+"";  
				    if (Double.parseDouble(longVal + ".0") == cell.getNumericCellValue())  
				    	cellvalue = longVal;  
				    else  
				    	cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			case Cell.CELL_TYPE_STRING:
				cellvalue = cell.getRichStringCellValue().toString();
				break;
			default:
				break;
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}
}
