package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	 
	String path;
	Sheet sheet;
	public FileInputStream fis;
	public Workbook wb;
	public Row row;
	public Cell cell;
	
	
	
	public ExcelFileUtility(String path) {
		this.path=path;
		
	}
	
	public int getRowCount(String sheetName) throws IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		sheet=wb.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
		
	}
	public int getCellCount(String sheetName, int rownum) throws  IOException {
		fis=new FileInputStream(path);
		wb=WorkbookFactory.create(fis);
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
		
	}
	public String getCellData(String sheetName,int rownum, int colnum) throws  IOException {
		
		fis=new FileInputStream(path);
		wb=WorkbookFactory.create(fis);
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell); //returns the formatted value of string regardless of any format
			
		} catch(Exception e) {
			data="";
		}
		wb.close();
		fis.close();
		return data;
		
		
		
		
		
		
		
		
		
		
		
		
	}
}