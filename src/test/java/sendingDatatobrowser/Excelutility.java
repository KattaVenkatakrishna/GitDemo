package sendingDatatobrowser;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;
	
	Excelutility(String path){
		this.path=path;
	}
	
	public int getRowCount(String sheetname) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetname,int rowname) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rowname);	
		int cellcount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
	}
public String getCellData(String sheetname,int rowname,int colname) throws IOException {
	fis = new FileInputStream(path);
	workbook = new XSSFWorkbook(fis);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rowname);
	cell=row.getCell(colname);
	DataFormatter formatter = new DataFormatter();
	String data;
	try {
		data=formatter.formatCellValue(cell);
	}catch (Exception e) {
		data="";
	}
	workbook.close();
	fis.close();
	return data;
}
}
