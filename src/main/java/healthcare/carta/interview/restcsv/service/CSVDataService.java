package healthcare.carta.interview.restcsv.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import healthcare.carta.interview.restcsv.models.CsvData;

@Service
public class CSVDataService {
	
	
	private static final String COMMA_DELIMITER = ",";

	public CsvData getAvarage(MultipartFile multipartFile,String columnNumber) throws CsvDataException {
		int records = 0;
		double sum =0;
		CsvData csvData = new CsvData();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        sum+=Double.valueOf(values[Integer.valueOf(columnNumber)-1]) ;
		        records++;
		    }
		    double average = sum/records;
			
			csvData.setData(average);
		} catch (Exception e) {
			throw new CsvDataException("Error in processing csv data");
		}
		
		return csvData;
	}
}
