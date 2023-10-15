package dv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataSource {

	@DataProvider(name = "somthing")
	public Object[][] dp() {

		return new Object[][] { new Object[] { "user1", "Pass1" }, new Object[] { "user2", "Pass2" }, };

		/*
		 * Object [][] object = new Object[2][2]; object [0][0] = "user1"; object [0][1]
		 * = "Pass1"; object [1][0] = "user2"; object [1][1] = "Pass2";
		 * 
		 * return object;
		 */
	}

	@DataProvider(name = "RONZU XMLDATA")
	public Object[][] getDatafromExcel() {
		XSSFWorkbook book = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("/Users/ihalder/eclipse-workspace/TestngFramework/Data.xlsx"));
			book = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found");
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (book != null) {
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		XSSFSheet sheet = book.getSheetAt(0);

		// sheet.getRow(5).getCell(0).getStringCellValue();
		int rs = sheet.getLastRowNum();
		int cs = sheet.getRow(0).getLastCellNum();

		Object[][] object = new Object[rs][cs];

		for (int i = 1; i <= rs; i++) {

			for (int j = 0; j <= cs; j++) {

				XSSFCell cell = sheet.getRow(i).getCell(j);
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_NUMERIC:
					object[i - 1][j] = cell.getNumericCellValue();

				case XSSFCell.CELL_TYPE_STRING:
					object[i - 1][j] = cell.getStringCellValue();
				}
			}
		}

		return object;
	}

	public void newwoo() {
		
		try { System.out.println(10/0);
			
		} catch (ArithmeticException e){ 
			
			
		}
			
		}

}
