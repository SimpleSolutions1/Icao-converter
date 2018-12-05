package org.icao.converter;

import java.util.Map;
import java.util.stream.Collectors;

public class IcaoConverterImpl implements IcaoConverter {

	private Map<String, String> converterMap;

	public IcaoConverterImpl(Map<String, String> converterMap) {
		this.converterMap = converterMap;
	}

	@Override
	public String convert(String line) {
		return line.chars() //
				.mapToObj(ch -> (char) ch) //
				.map(ch -> converterMap.getOrDefault(ch.toString(), ch.toString())) //
				.collect(Collectors.joining("")).concat("\r\n");
	}
}
