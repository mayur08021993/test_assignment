package healthcare.carta.interview.restcsv.contoller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import healthcare.carta.interview.restcsv.models.CsvData;
import healthcare.carta.interview.restcsv.service.CSVDataService;



@RunWith(SpringRunner.class)
@WebMvcTest(value = CsvApplicationControllerTest.class)
@WithMockUser
public class CsvApplicationControllerTest {
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	CSVDataService service;
	
	@Test
	public void testAverageByColumn() throws Exception {
		CsvData mockData = new CsvData();
		mockData.setData(10.0);

		Mockito.when(service.getAvarage(Mockito.any(MultipartFile.class), Mockito.anyString())).thenReturn(mockData);
		
		MockMultipartFile mockFile = new MockMultipartFile("mockFile", "", "application/json", "\"abcd\",\"10\"".getBytes());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.multipart("/csvData/average/2").file(mockFile);
		
		MvcResult mvcResult =  mockMvc.perform(requestBuilder).andReturn();
		
		String actualResponse = mvcResult.getResponse().getContentAsString();
		
		String expectedResponse = "{\"data\":10.0}";
		
		assertEquals(expectedResponse, actualResponse);
	}
}
