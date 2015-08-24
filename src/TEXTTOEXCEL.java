import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TEXTTOEXCEL {

	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		System.out.println("TxtToExcel Prog. V1.5");
		System.out.println("In progress...");
		File inputFile = new File("C:\\Users\\lg358209sd\\Desktop\\Vega_Alta_EDS100P.txt");
		FileOutputStream outputFile = new FileOutputStream(new File("C:\\Users\\lg358209sd\\Desktop\\test.xlsx"));
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet worksheet = workbook.createSheet("POI Worksheet");
	
				
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
	//	StringBuffer stringBuffer = new StringBuffer();
		
		int i = 0;
		String line;			
		String last =" ";
		
		while ((line = bufferedReader.readLine()) != null) {	
			
			String CATNUM = line.substring(0, line.indexOf(' '));
			
			//last = line.substring(0, line.indexOf(' '));
			
			if(!last.equals(CATNUM) || i == 0){
				
			XSSFRow row = worksheet.createRow(i);			
			XSSFCell cell = row.createCell(0);
			cell.setCellValue(CATNUM.trim());			
		
			i++;
			last = CATNUM;
			
			}
			
						
		
		}
		workbook.write(outputFile);
		workbook.close();
		
		fileReader.close();

		
		System.out.println("DONE!");
	}
		

}
