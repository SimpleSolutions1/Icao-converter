package org.icao.converter;

import java.util.List;

import org.icao.model.coverter.Converter;
import org.icao.repository.ConverterRepository;
import org.icao.service.ConverterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ConverterComponentTest {

	@Autowired
	ConverterRepository converterRepository;
	@Autowired
	ConverterService converterService;
	@Autowired
	ConverterComponent converterComponent;

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Test
	public void testConverInputFromDataBase_GivenDataFromDatabase_ThenReturnConwertedText() {
		converterComponent.convert();
		List<Converter> converterList = converterRepository.findAll();
		Assert.assertEquals("Tower", converterList.get(0).getInputText());
		Assert.assertEquals("TangoOscarWhiskeyEchoRomeo\r\n", converterList.get(0).getOutputText());
	}
}
