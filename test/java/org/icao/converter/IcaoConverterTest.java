package org.icao.converter;

import org.icao.data.IcaoConverterMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IcaoConverterTest {

	private IcaoConverterMap icaoConverterMap;

	@Before
	public void setUp() {
		icaoConverterMap = new IcaoConverterMap();
		icaoConverterMap.getConverterMap();
	}

	@Test
	public void testConverter_WhenLineContainAlphabet() {
		// Given
		IcaoConverterImpl icaoConverter = new IcaoConverterImpl(icaoConverterMap.getConverterMap());
		String line = "ABCDE";
		// When
		String actual = icaoConverter.convert(line);
		// Then
		String expected = "AlphaBravoCharlieDeltaEcho\r\n";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testConverter_WhenLineDoesNotConstrainAlphabet() {
		// Given
		IcaoConverterImpl icaoConverter = new IcaoConverterImpl(icaoConverterMap.getConverterMap());
		String line = "*9*0";
		// When
		String actual = icaoConverter.convert(line);
		// Then
		String expected = "*Niner*Zero" + "\r\n";
		Assert.assertEquals(expected, actual);
	}
}
