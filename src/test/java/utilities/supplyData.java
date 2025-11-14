package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class supplyData {
	@Test(dataProvider = "data")
	public Object[][] sendData(String path, String sheetname) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowcount - 1][colcount];
		for (int i = 1; i < rowcount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				data[i - 1][j] = row.getCell(j).toString();
			}
		}
		return data;
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws FileNotFoundException {
		Object[][] d = sendData("C:\\Users\\91832\\OneDrive\\Desktop\\Data.xlsx", "Sheet1");
		return d;
	}
}
