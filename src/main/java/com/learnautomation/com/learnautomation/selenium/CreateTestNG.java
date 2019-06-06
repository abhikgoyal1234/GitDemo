package com.learnautomation.com.learnautomation.selenium;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.*;
import org.w3c.dom.*;



import framework.Excel;



public class CreateTestNG {

	XSSFWorkbook guru99Workbook ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i = 25 ;
		  System.out.println("Test");
		try {
			DocumentBuilderFactory dbfactory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbfactory.newDocumentBuilder();
			System.out.println("Test1");
	       Document doc =  dbBuilder.newDocument();
	       
	       Element rootElement = doc.createElement("suite");
	       doc.appendChild(rootElement);	       
	       Attr rootNameAttribute = doc.createAttribute("name") ;
	       rootNameAttribute.setValue("softwaretestingmaterial");	       
	       rootElement.setAttributeNode(rootNameAttribute);
	       
	       System.out.println("Test2");
	       Element testElement = doc.createElement("test");
	       rootElement.appendChild(testElement);       
	       Attr testNameAttribute1 = doc.createAttribute("name") ;
	       testNameAttribute1.setValue("test cases 1");	       
	       testElement.setAttributeNode(testNameAttribute1);
	       
	       
	       Element paraMeterElement = doc.createElement("parameter");
	       testElement.appendChild(paraMeterElement);       
	       Attr parameterNameAttribute = doc.createAttribute("name") ;
	       parameterNameAttribute.setValue("url");	
	       Attr parameterValueAttribute = doc.createAttribute("value") ;
	       parameterValueAttribute.setValue("http://www.demo.guru99.com/V4/");
	       
	       paraMeterElement.setAttributeNode(parameterNameAttribute);
	       paraMeterElement.setAttributeNode(parameterValueAttribute);
	       
	       Element paraMeterElement2 = doc.createElement("parameter");
	       testElement.appendChild(paraMeterElement2);       
	       Attr parameterNameAttribute2 = doc.createAttribute("name") ;
	       parameterNameAttribute2.setValue("exPath");	
	       Attr parameterValueAttribute2= doc.createAttribute("value") ;
	       parameterValueAttribute2.setValue("E:\\Eclipse\\Mercurytours\\TestData\\Guru99DemoDataSheet1.xlsx");
	       
	       paraMeterElement2.setAttributeNode(parameterNameAttribute2);
	       paraMeterElement2.setAttributeNode(parameterValueAttribute2);
	       
	       
	       Element classesElement = doc.createElement("classes");
	       testElement.appendChild(classesElement);  
	       
	       
	       Excel exData = new Excel("E:\\Eclipse\\Mercurytours\\TestData\\Guru99DemoDataSheet.xlsx");
	       Object[][] objMap=exData.getloadDataINHashMap();
	       
	       
	       
	       for(int j=0; j <objMap.length ;j++) {
	    	  HashMap map = (HashMap) objMap[j][0];
	    	  if(map.get("Execute").toString().equals("Y")) {
	    		  Element classElement = doc.createElement("class");
		    	   classesElement.appendChild(classElement);   	    	   
		    	   Attr classNameAttribute = doc.createAttribute("name") ;
		    	   classNameAttribute.setValue(map.get("TestName").toString());	    	   
		    	   classElement.setAttributeNode(classNameAttribute);	
	    		  
	    	  }
	    	  
	    	   
	       }
	        
	   /*  File  file = new File("E:\\Eclipse\\Mercurytours\\TestData\\Guru99DemoDataSheet.xlsx");
	       FileInputStream fileinptStrm = new FileInputStream(file);
	       
	       XSSFWorkbook guru99Workbook = new XSSFWorkbook(fileinptStrm);
	       XSSFSheet sh1 = guru99Workbook.getSheetAt(0);
	       int rowNum = sh1.getPhysicalNumberOfRows();
	       HashMap<String,String> map = new HashMap<String,String>();
	       
	  	 for(int j =0 ; j<rowNum-1 ;j++) {
	  		 
	  		
			 
			 XSSFRow rowData =sh1.getRow(j);
			int  rowValue=j;
			 int cellNum = rowData.getPhysicalNumberOfCells();
			 for(int i =0; i<cellNum;i++) {
					map.put(sh1.getRow(0).getCell(i).getStringCellValue().toString(), sh1.getRow(j+1).getCell(i).getStringCellValue().toString());
					
					System.out.println(sh1.getRow(0).getCell(i).getStringCellValue());
					System.out.println(sh1.getRow(j+1).getCell(i).getStringCellValue());
				}
			 System.out.println("xyz"+sh1.getRow(0).getCell(j+1).getStringCellValue());
				System.out.println(sh1.getRow(j+1).getCell(j+1).getStringCellValue());
				
	  	 }*/
	      /* System.out.println("Test3");
	       Fillo fillo = new Fillo();
	       Connection con = fillo.getConnection("E:\\Eclipse\\Mercurytours\\TestData\\Guru99DemoDataSheet.xlsx");	       
	       System.out.println("Test4");
	       String query = "Select * from Sheet1";	       
	       System.out.println("Test6");	     
	       Recordset recordSet =con.executeQuery(query);
	       
	       
	       
	       System.out.println("Test5");
	       while(recordSet.next()){
	    	   if (recordSet.getField("Execute").equals("Y")) {
	    	   Element classElement = doc.createElement("class");
	    	   classesElement.appendChild(classElement);   	    	   
	    	   Attr classNameAttribute = doc.createAttribute("name") ;
	    	   classNameAttribute.setValue(recordSet.getField("TestName"));	    	   
	    	   classElement.setAttributeNode(classNameAttribute);	
	    	   
	    	   }*/
	      /* }
			
			recordSet.close();
			con.close();*/
			 TransformerFactory transformerFactory = TransformerFactory
	                    .newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(new File("./testNg.xml"));
	            transformer.transform(source, result);
	            // Output to console for testing
	            StreamResult consoleResult = new StreamResult(System.out);
	            transformer.transform(source, consoleResult);
	       
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
