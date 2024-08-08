package com.santander.chl.csvexp.chl_csvexp_trnsftask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CsvRequest {

	@JsonProperty("username")
	private String username;
	@JsonProperty("id")
	private String id;
	@JsonProperty("password")
	private String password;
}
