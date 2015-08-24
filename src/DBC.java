import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DBC {

	static ArrayList<String> catnumbers = new ArrayList<String>();
	static String nemaText = "NEMASize";
	
public static void main(String[] args) throws IOException, InvalidFormatException {
		
	
	
	
		System.out.println("DBC Prog. V1.0");
		System.out.println("In progress..."+"\n");
		
		File inputFile1 = new File("C:\\Users\\lg358209sd\\Desktop\\CATALOGNUMBERS.txt");
		File inputFile = new File("C:\\Users\\lg358209sd\\Desktop\\Vega_Alta_EDS100P.txt");
		//txtTOarray(inputFile1);
		
		FileOutputStream outputFile = new FileOutputStream(new File("C:\\Users\\lg358209sd\\Desktop\\test2.xlsx"));
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet worksheet = workbook.createSheet("VA_DB");
					
		FileReader fileReader = new FileReader(inputFile);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		BufferedWriter writer = new BufferedWriter(new FileWriter( new File("C:\\Users\\lg358209sd\\Desktop\\output.txt")));
	   
	  
		int i = 0;
		String line;			
		//String last =" ";
		//String catnum = catnumbers.get(0);	
		String temp;
		
		while ((line = bufferedReader.readLine()) != null) {	
				
			String shortenLine = line.replaceAll("\\s+","");
			
			String sizeLineF = nemaText;
			
						
			if(shortenLine.contains(sizeLineF))
			{				
				 
				
				String cat = line.substring(0,line.indexOf(' '));
				String output = shortenLine.substring(shortenLine.lastIndexOf('e')+1, shortenLine.length());
				temp = (cat+" "+output);
				writer.write(temp);
				writer.newLine();
			}
			
					
			
			i++;	
			
			
			
		/*	String nema = 
			
			String CATNUM = line.substring(0, line.indexOf(' '));
			
			CATNUM.replaceAll("\\s+","");
			
			if(!last.equals(CATNUM) || i == 0){				
				
				
			XSSFRow row = worksheet.createRow(i);			
			XSSFCell cell = row.createCell(0);
			cell.setCellValue(CATNUM.trim());			
		
			
			last = CATNUM;
			
			}*/
			
			
		
		}
		workbook.write(outputFile);
		workbook.close();
		  writer.close();
		fileReader.close();

		
		System.out.println("\n"+"DONE!");
	}

	public static void txtTOarray(File file) throws FileNotFoundException
		{
		Scanner s = new Scanner(file);
	
		while (s.hasNext()){
			catnumbers.add(s.next());
							}
				s.close();
		}

}
