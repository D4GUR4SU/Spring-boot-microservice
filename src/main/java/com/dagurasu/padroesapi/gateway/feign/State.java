package com.dagurasu.padroesapi.gateway.feign;

import java.util.List;

import com.dagurasu.padroesapi.gateway.json.JsonState;

import feign.RequestLine;

public interface State {

	@RequestLine("GET /api/v1/localidades/estados")
	List<JsonState> get();
}
