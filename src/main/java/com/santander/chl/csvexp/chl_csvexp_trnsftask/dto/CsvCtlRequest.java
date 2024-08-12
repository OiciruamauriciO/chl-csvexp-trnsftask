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
public class CsvCtlRequest {
	
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("apellido")
	private String apellido;
	@JsonProperty("nacionalidad")
	private String nacionalidad;
	@JsonProperty("tipoDocumento")
	private String tipoDocumento;
	@JsonProperty("numeroDocumento")
	private Integer numeroDocumento;
	@JsonProperty("fechaNacimiento")
	private String fechaNacimiento;
	@JsonProperty("sexo")
	private String sexo;	
}
