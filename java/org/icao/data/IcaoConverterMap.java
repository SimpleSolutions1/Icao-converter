package org.icao.data;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class IcaoConverterMap {
	private Map<String, String> converterIcaoMap;

	public Map<String, String> getConverterMap() {
		if (this.converterIcaoMap == null || this.converterIcaoMap.isEmpty()) {
			this.converterIcaoMap = createConvertMap();
		}
		return this.converterIcaoMap;
	}

	private Map<String, String> createConvertMap() {
		Map<String, String> converterMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		converterMap.putAll(createAlphabet());
		converterMap.putAll(createNumberMap());
		return Collections.unmodifiableMap(converterMap);
	}

	private Map<String, String> createAlphabet() {
		TreeMap<String, String> icaoAlphabetMap = new TreeMap<>();
		icaoAlphabetMap.put("A", "Alpha");
		icaoAlphabetMap.put("B", "Bravo");
		icaoAlphabetMap.put("C", "Charlie");
		icaoAlphabetMap.put("D", "Delta");
		icaoAlphabetMap.put("E", "Echo");
		icaoAlphabetMap.put("F", "Foxtrot");
		icaoAlphabetMap.put("G", "Golf");
		icaoAlphabetMap.put("H", "Hotel");
		icaoAlphabetMap.put("I", "India");
		icaoAlphabetMap.put("J", "Juliett");
		icaoAlphabetMap.put("K", "Kilo");
		icaoAlphabetMap.put("L", "Lima");
		icaoAlphabetMap.put("M", "Mike");
		icaoAlphabetMap.put("N", "November");
		icaoAlphabetMap.put("O", "Oscar");
		icaoAlphabetMap.put("P", "Papa");
		icaoAlphabetMap.put("Q", "Quebec");
		icaoAlphabetMap.put("R", "Romeo");
		icaoAlphabetMap.put("S", "Sierra");
		icaoAlphabetMap.put("T", "Tango");
		icaoAlphabetMap.put("U", "Uniform");
		icaoAlphabetMap.put("V", "Victor");
		icaoAlphabetMap.put("W", "Whiskey");
		icaoAlphabetMap.put("X", "X-Ray");
		icaoAlphabetMap.put("Y", "Yankee");
		icaoAlphabetMap.put("Z", "Zulu");
		return icaoAlphabetMap;

	}

	private Map<String, String> createNumberMap() {
		TreeMap<String, String> icaoNumberMap = new TreeMap<>();
		icaoNumberMap.put("0", "Zero");
		icaoNumberMap.put("1", "One");
		icaoNumberMap.put("2", "Two");
		icaoNumberMap.put("3", "Tree");
		icaoNumberMap.put("4", "Fower");
		icaoNumberMap.put("5", "Fife");
		icaoNumberMap.put("6", "Six");
		icaoNumberMap.put("7", "Seven");
		icaoNumberMap.put("8", "Eight");
		icaoNumberMap.put("9", "Niner");

		return icaoNumberMap;

	}

}
