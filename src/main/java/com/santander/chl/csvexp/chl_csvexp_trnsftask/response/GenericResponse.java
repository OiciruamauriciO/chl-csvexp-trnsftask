package com.santander.chl.csvexp.chl_csvexp_trnsftask.response;

import java.io.FileWriter;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {

	@JsonProperty("status")
	private int status;	
	@JsonProperty("message")
	private String message;	
	@JsonProperty("csv")
	private FileWriter csv;
}
