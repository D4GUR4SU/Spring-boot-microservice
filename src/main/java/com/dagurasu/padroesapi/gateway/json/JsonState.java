package com.dagurasu.padroesapi.gateway.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonState implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String fu;
	private String name;
}
