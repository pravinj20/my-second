package com.javatec.crud.oprn.dto;

public class APIResponse<T> {
	int recordCount;
	T response;
	
	
	public APIResponse() {
		
	}


	public APIResponse(int recordCount, T response) {
		
		this.recordCount = recordCount;
		this.response = response;
	}

}
