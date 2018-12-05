package org.icao.converter;

import java.util.List;

import org.icao.exception.ThereIsNoDataToConvert;
import org.icao.model.coverter.Converter;
import org.icao.repository.ConverterRepository;
import org.icao.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterComponent {

	@Autowired
	ConverterRepository converterRepository;
	@Autowired
	ConverterService converterService;

	public void convert() {
		List<Converter> dataToConvert = converterRepository.findAll();
		if (dataToConvert.isEmpty()) {
			throw new ThereIsNoDataToConvert("There is no data to convert in database");
		}
		for (Converter converterData : dataToConvert) {
			String convertedText = this.converterService.convertDataFromDataBase(converterData.getInputText());
			converterData.setOutputText(convertedText);
			this.converterRepository.save(converterData);
		}

	}
}
