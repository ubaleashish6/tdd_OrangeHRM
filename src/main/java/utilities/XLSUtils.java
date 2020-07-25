package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSUtils {

	public static FileInputStream fis;
	public static FileOutputStream fout;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String file, String xlSheet) throws IOException {

		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}

	public static int getCellCount(String file, String xlSheet, int rowNum) throws IOException {

		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		row=sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	public static String getCellData(String file, String xlSheet, int rowNum, int cellNum) throws IOException {
		
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		String cellValue="";
		if(cell==null)
			return null;
		if(cell.getCellType()==CellType.STRING) {
			cellValue=cell.getStringCellValue();
		}
		/*
		 * else if(cell.getCellType()==CellType.NUMERIC) {
		 * cellValue=cell.getNumericCellValue(); }
		 */
			
		return cellValue;
	}

}
