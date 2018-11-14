package com.jang.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel01 {
	public static void main(String[] args) {
		
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		Label label = null;
		File file = new File("c:\\temp\\excel02.xls");
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("이름", "홍길동2");
		hashMap.put("나이", "30");
		
		HashMap<String, String> hashMap2 = new HashMap<>();
		hashMap2.put("이름", "임길동");
		hashMap2.put("나이", "20");
		hashMap2.put("연도", "=1950 + YEAR()");
		
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>(); // <키, 값> 이것이 해쉬맵
		
		arrayList.add(hashMap);
		arrayList.add(hashMap2);
		
		try {
			workbook = Workbook.createWorkbook(file);
			workbook.createSheet("명단", 0);// 1번시트가 0임
			sheet = workbook.getSheet(0);
			label = new Label(0,0,"이름");
			sheet.addCell(label);
			label = new Label(1,0,"나이");
			sheet.addCell(label);
			label = new Label(2,0,"연도");
			sheet.addCell(label);
			
			//반복문에 넣어서...
			HashMap<String, String> result = arrayList.get(0);
			label = new Label(0,1,result.get("이름"));
			sheet.addCell(label);
			//
			for (int i = 0; i < arrayList.size(); i++) {
				HashMap<String, String> rs = arrayList.get(i);
				label = new Label(0,(i + 1),rs.get("이름"));
				sheet.addCell(label);
				label = new Label(1,(i + 1),rs.get("나이"));
				sheet.addCell(label);
				label = new Label(2,(i + 1),rs.get("연도"));
				sheet.addCell(label);
				
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
