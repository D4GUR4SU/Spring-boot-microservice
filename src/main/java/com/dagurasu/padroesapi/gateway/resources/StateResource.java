package com.dagurasu.padroesapi.gateway.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dagurasu.padroesapi.gateway.feign.State;

import feign.Feign;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;

@RestController
public class StateResource {

	@Autowired
	ErrorDecoder errorDecoder;

	@GetMapping("/api/states/")
	public ResponseEntity getEstates() {

		State state = Feign.builder()
				.decoder(new GsonDecoder())
				.errorDecoder(errorDecoder)
				.target(State.class, "http://servicodados.ibge.gov.br");

		return new ResponseEntity<>(state.get(), HttpStatus.OK);
	}

}
