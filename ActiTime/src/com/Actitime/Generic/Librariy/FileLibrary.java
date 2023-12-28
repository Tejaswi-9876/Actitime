package com.Actitime.Generic.Librariy;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this  class  is a generic class desigened to read data from p
 * @author Tejaswini chavhan
 *
 */


public class FileLibrary {
	public String readDatafromPropertyfile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data; 
	}

/**
 * this method is a generic method  
 * @param sheet
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */


public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis =new FileInputStream("./testdata/testdata.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	String data =wb.getSheet(sheet).getRow(cell).getCell(cell).getStringCellValue();
	return data;
	}
	}
	