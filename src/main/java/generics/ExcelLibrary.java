package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements AutoConstant
{

	public static String getcellvalue(String sheet_name, int rownum, int cellvalue) throws IOException 
	{
		
		FileInputStream f = new FileInputStream(excel_path);
		XSSFWorkbook b= new XSSFWorkbook(f);
		String cellValue=b.getSheet(sheet_name).getRow(rownum).getCell(cellvalue).getStringCellValue();
		
		b.close();
		return cellValue;
	
	}
	
}
