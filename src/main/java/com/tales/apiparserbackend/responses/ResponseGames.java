package com.tales.apiparserbackend.responses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;

import com.tales.apiparserbackend.dtos.GameDto;

public class ResponseGames<T> extends Response{

	private Optional<List<GameDto>> data;
	private List<String> errors;

	public ResponseGames() {
	}

	public Optional<List<GameDto>> getData() {
		return data;
	}



	public void setData(Optional<List<GameDto>> gamesDto) {
		this.data = gamesDto;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
