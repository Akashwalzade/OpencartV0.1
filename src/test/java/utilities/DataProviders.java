package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="logindata")
	public String [][] getdata() throws IOException{
		String path = ".\\testData\\OpenCart_LoginData.xlsx";
		
		ExcelUtility xlutility = new ExcelUtility(path); //Creating an object for XLUtility
		
		int totalrow = xlutility.getRowCount("Sheet1");
		int totalcols = xlutility.getCellCount("Sheet1",1);
		
		String logindata [][]= new String[totalrow][totalcols];//created fro two iamensional array which can store the 
		
		for(int i=1;i<=totalrow;i++) {
			for(int j=0;j<totalcols;j++)  // i is rown and j is column
			{ 
				
				logindata [i-1][j]=xlutility.getCellData("Sheet1",i,j);
				
			}
		}		
		
		return logindata;
		
	}

}
