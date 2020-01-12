package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.gargoylesoftware.htmlunit.javascript.host.worker.Worker;
import com.google.common.io.Files;

public class Lib implements IAutoConstant{

	public static  Workbook wb;
	public static String getPropertyValue(String propertyname) {
		String propertyValue="";
		try {
//			FileInputStream fis=new FileInputStream(CONFIGFILEPATH);
			Properties prop=new Properties();
			prop.load(new FileInputStream(CONFIGFILEPATH));
//			String key;
			//fetch the value
			propertyValue=prop.getProperty(propertyname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return propertyValue;
	}

	public static void captureScreenshot(WebDriver driver,String testMethodName) {
		
//		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDateAndTime=new Date().toString().replaceAll(":", "_");
		File destFile=new File(SCREENSHOT_PATH +testMethodName+""+currentDateAndTime+".png");

		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static  String getCellData( String excelFileName,String sheetName,int rowNum,int colNum)
	{
		String cellValue="";
		try {
		FileInputStream fis=new FileInputStream(EXCEL_FILE_PATH+excelFileName+".xlsx");
//		wb= WorkbookFactory.create(fis);
//		Sheet sh=wb.getSheet(sheetName);
//		Row row=sh.getRow(rowNum);
//		cellValue=row.getCell(colNum).toString();
		
cellValue=WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		} 
		catch (Exception e) {}
		return cellValue;
	}
	
	
	public static int getRowCount(String excelFileName,String sheetName) {
		int rowCount=0;
		try {
//			 wb=WorkbookFactory.create(new File(EXCEL_FILE_PATH+excelFileName+".xlsx"));
//			 Sheet sh=wb.getSheet(sheetName);
//			 rowCount=sh.getLastRowNum();
 rowCount=WorkbookFactory.create(new File(EXCEL_FILE_PATH+excelFileName+".xlsx")).getSheet(sheetName).getLastRowNum();
			 
			 
		} catch (Exception e) {
		} 
		
		return rowCount;
	}
	
	
	
	
	
	
}
