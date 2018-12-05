package org.icao.model.coverter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "converter")
public class Converter implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Long id;

	@Lob
	@Column(name = "input_text")
	private String inputText;
	@Lob
	@Column(name = "output_text")
	private String outputText;

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public String getOutputText() {
		return outputText;
	}

	public void setOutputText(String outputText) {
		this.outputText = outputText;
	}

}
