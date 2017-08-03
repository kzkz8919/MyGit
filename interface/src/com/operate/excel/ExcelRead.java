package com.operate.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelRead {

	public static void excelAction(String filepath){
		File file = new File(filepath);
		try {
			FileInputStream in = new FileInputStream(file);
			Workbook workBook = WorkbookFactory.create(in);
			Sheet sheet = workBook.getSheet("sheet1");
			int numRows = sheet.getLastRowNum()+1;
			Row row = sheet.getRow(0);
			int numCloumn = row.getLastCellNum();
			System.out.println("行数："+numRows+" "+"列数："+numCloumn);
			Cell cell = row.getCell(0);
			String v = cell.getStringCellValue();
			System.out.println(v);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExcelRead.excelAction("e:/excel_test.xlsx");
	}
}
