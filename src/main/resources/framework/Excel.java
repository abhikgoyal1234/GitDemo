package framework;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public XSSFWorkbook wb;
	public XSSFSheet sh1;
	public XSSFRow rowData;
	public HashMap<String,String> map;
	public ArrayList<Object> obData ;
	public static int rowValue;
	public File file ;
	public Excel(String excelPath) {
		// TODO Auto-generated constructor stub
		  file = new File(excelPath);
		    //"E:\\Eclipse\\Mercurytours\\TestData\\Guru99DemoDataSheet.xlsx"
		    FileInputStream fileSrc; 
			try {
				fileSrc = new FileInputStream(file);
			
		    
		         wb = new XSSFWorkbook(fileSrc);
		       
		        }
		    
		    catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		    
	}
    
	
	public void loadCredInMap(String getMethodName) {
		 map = new HashMap<String,String>();
		sh1 = wb.getSheet("credential");

		System.out.println("amit");
		int RowNum = sh1.getLastRowNum();
		System.out.println("amrit");
		int counter =0;
		int counterValue =0;
		System.out.println(RowNum);
		for ( int i =0; i<=RowNum;i++)
		{
			rowData =sh1.getRow(i);
			System.out.println(rowData.getCell(0).getStringCellValue().toString());
			System.out.println("getMethodName:"+getMethodName);
			if (rowData.getCell(0).getStringCellValue().equals(getMethodName)) {
				System.out.println(counter);
                counterValue = counter;
                System.out.println("counterValue:"+counter);
			}
			++counter;
			System.out.println("counter:"+counter);
		}
		int cellFirstNum = rowData.getPhysicalNumberOfCells();	
		int cellNum = rowData.getLastCellNum();	
		System.out.println("cellNum:"+cellNum);
		System.out.println("cellFirstNum:"+cellFirstNum);
		for(int i =0; i<cellNum;i++) {
			map.put(sh1.getRow(0).getCell(i).getStringCellValue(), sh1.getRow(counterValue).getCell(i).getStringCellValue());
			
			System.out.println(sh1.getRow(0).getCell(i).getStringCellValue());
			System.out.println(sh1.getRow(counterValue).getCell(i).getStringCellValue());
		}
		
	}
	
	public Object[][] getloadDataINHashMap(){
		 System.out.println("I am in getloadDataINHashMap");
		 map = new HashMap<String,String>();
		 sh1 = wb.getSheet("Credential");
		 int rowNum = sh1.getPhysicalNumberOfRows();
		 System.out.println("physical Row Number"+rowNum);
		 Object[][] obj = new Object[rowNum-1][1];
		 for(int j =0 ; j<rowNum-1 ;j++) {
			 HashMap<String,String> map = new HashMap<String,String>();
			 rowData =sh1.getRow(j);
			 rowValue=j;
			 int cellNum = rowData.getPhysicalNumberOfCells();
			 for(int i =0; i<cellNum;i++) {
					map.put(sh1.getRow(0).getCell(i).getStringCellValue().toString(), sh1.getRow(j+1).getCell(i).getStringCellValue().toString());
					
					System.out.println(sh1.getRow(0).getCell(i).getStringCellValue());
					System.out.println(sh1.getRow(j+1).getCell(i).getStringCellValue());
				}
		
			 obj[j][0]=map;
		 }
		  
		
		
		
		return obj;}

	public String getData(String Var)
	{   String data = null ;
		if(Var.startsWith("c_")) {
			 data = map.get(Var);
		}
		return data;
		
	}
	public void writeResultStatus(String status) throws Exception {
		System.out.println("I am writing something");
		 sh1 = wb.getSheet("Credential");
		 sh1.getRow(rowValue).createCell(3).setCellValue(status);
		 
	    
		 
		
			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			rowValue = rowValue  +1; 
	}
}
