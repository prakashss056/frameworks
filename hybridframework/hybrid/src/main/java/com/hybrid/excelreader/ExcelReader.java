package com.hybrid.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String[][] getExcelData(String excellocation, String sheetName) {
		try {
			String[][] dataSets = null;
			FileInputStream file = new FileInputStream(new File(excellocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum() + 1;
			int totalColumn = sheet.getRow(0).getLastCellNum();
			
			dataSets = new String[totalRow - 1][totalColumn];
			
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			int t = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (i++ != 0) {
					int k = t;
					t++;
					Iterator<Cell> cellIterator = row.cellIterator();
					int j = 0;
					while (cellIterator.hasNext()) {
						Cell notecell = cellIterator.next();
						switch (notecell.getCellType()) {

						case Cell.CELL_TYPE_NUMERIC:
							dataSets[k][j++] = notecell.getStringCellValue();
							System.out.println(notecell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							dataSets[k][j++] = notecell.getStringCellValue();
							System.out.println(notecell.getStringCellValue());
							break;

						case Cell.CELL_TYPE_BOOLEAN:
							dataSets[k][j++] = notecell.getStringCellValue();
							System.out.println(notecell.getStringCellValue());
							break;

						case Cell.CELL_TYPE_FORMULA:
							dataSets[k][j++] = notecell.getStringCellValue();
							System.out.println(notecell.getStringCellValue());
							break;
						}
					}
				}

			}
			file.close();
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
