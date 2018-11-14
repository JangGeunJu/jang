package com.jang.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel03 {
	public static void main(String[] args) {
		Workbook workbook = new HSSFWorkbook();//~2003		
		Sheet sheet = workbook.createSheet();
		
		Row row = null;
		Cell cell = null;
		
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("¹øÈ£");
	}
}
