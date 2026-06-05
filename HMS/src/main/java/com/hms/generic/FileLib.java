package com.hms.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	 public String getPropertyData(String key) throws IOException {
   	 FileInputStream fis = new FileInputStream("./src/test/resources/data/Commondata.property");
   	 Properties p = new Properties();
   	 p.load(fis);
   	 String data = p.getProperty(key);
   	 return data;
    }
    
    public String getExcelData(String sheetname, int row_number, int cell_num) throws EncryptedDocumentException, IOException {
   	 FileInputStream fis = new FileInputStream("./src/test/resources/data/testscript.xlsx");
   	 Workbook wb = WorkbookFactory.create(fis);
   	 String data = wb.getSheet(sheetname).getRow(row_number).getCell(cell_num).getStringCellValue();
   	 return data;
   	 
    }
    
    public void setExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue("Passed");
		//convert java readable format to external resource file.;
		FileOutputStream fos = new FileOutputStream("./src/test/resources/data/testscript.xlsx");
		wb.write(fos);

	}
}
