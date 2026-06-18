package genericUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //taking excel file from test data
		 ExcelFileUtility xutil=new ExcelFileUtility(path); //creating an object os=f excel utility
		 
		 int totalrows = xutil.getRowCount("Sheet1");
		int totalcols= xutil.getCellCount("Sheet1", 1);
		String LoginData[][]=new String[totalrows][totalcols]; //created 2-d array which store rows and columns number
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				LoginData[i-1][j]=xutil.getCellData("Sheet1", i, j);
			}
			
		}
		return LoginData; //returning 2-D array
		
		
		 
		 
	}
	

}
