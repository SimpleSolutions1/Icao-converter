package org.icao.service;

import org.icao.converter.IcaoConverterImpl;
import org.icao.data.IcaoConverterMap;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

	public String convertDataFromDataBase(String inputText) {
		IcaoConverterMap icaoConverterMap = new IcaoConverterMap();
		IcaoConverterImpl icaoConverter = new IcaoConverterImpl(icaoConverterMap.getConverterMap());
		return icaoConverter.convert(inputText);
	}

}
