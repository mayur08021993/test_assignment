package healthcare.carta.interview.restcsv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import healthcare.carta.interview.restcsv.models.CsvData;
import healthcare.carta.interview.restcsv.service.CSVDataService;
import healthcare.carta.interview.restcsv.service.CsvDataException;


@RestController
@RequestMapping("/csvData")
public class CsvApplicationController {
	
	@Autowired
	CSVDataService service;
	
	@PostMapping(value="/average",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> averageByColumn(@RequestParam("column") String columnNumber,@RequestParam("file") MultipartFile file)  {
		
		try {
			CsvData data = service.getAvarage(file, columnNumber);
			return new  ResponseEntity<Object>(data,null,HttpStatus.OK);
		} catch (CsvDataException e) {
			return new  ResponseEntity<Object>(e.getErrMsg(),null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
