package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
 public WebDriver initialmethd() throws IOException{
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chrome//chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return d;
 }
 public Properties getProperties() throws IOException{
	 String path=System.getProperty("user.dir")+"//src//main//java//gloabl.properties";
		FileInputStream fis=new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
 }
 public ArrayList<String> getData(String testMethodName) throws IOException{
	 ArrayList<String> al= new ArrayList<String>();
	 String path=System.getProperty("user.dir")+"//src//main//java//project1.xlsx";
	 FileInputStream fis=new FileInputStream(path);
	 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 XSSFSheet worksheet=null;
	 int sheets = workbook.getNumberOfSheets();
	 for(int i=0;i<sheets;i++){
		 if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(testMethodName))
		 {
			 worksheet=workbook.getSheetAt(i);
			 Iterator<Row> row = worksheet.iterator();
			 while(row.hasNext())
			 {
				Row r = row.next();
				Iterator<Cell> cell =r.cellIterator();
				while(cell.hasNext())
				{
					Cell c = cell.next();
					if(c.getCellType() == CellType.STRING){
						al.add(c.getStringCellValue());
					}
					else{
						al.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
					
				}

			 }
		 }
		 
	 }
	return al;
	 
 }
 public ArrayList<ArrayList<String>> getDimensionalData(String testMethodName) throws IOException{
	 ArrayList<ArrayList<String>> al1 = new ArrayList<ArrayList<String>>();
	 String path=System.getProperty("user.dir")+"//src//main//java//project1.xlsx";
	 FileInputStream fis=new FileInputStream(path);
	 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 XSSFSheet worksheet=null;
	 int sheets = workbook.getNumberOfSheets();
	 for(int i=0;i<sheets;i++){
		 if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(testMethodName))
		 {
			 worksheet=workbook.getSheetAt(i);
			 Iterator<Row> row = worksheet.iterator();
			 while(row.hasNext())
			 { ArrayList<String> al= new ArrayList<String>();
				Row r = row.next();
				Iterator<Cell> cell =r.cellIterator();
				while(cell.hasNext())
				{
					Cell c = cell.next();
					if(c.getCellType() == CellType.STRING){
						al.add(c.getStringCellValue());
					}
					else{
						al.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
					
				}
				al1.add(al);
			 }
		 }
		 
	 }
	return al1;
	 
 } 
 
}
