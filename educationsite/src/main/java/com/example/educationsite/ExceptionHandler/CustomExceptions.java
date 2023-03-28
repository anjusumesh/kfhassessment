package com.example.educationsite.ExceptionHandler;


public class CustomExceptions extends RuntimeException{
	
	private String errMsg;
	
	public CustomExceptions(String errMsg)
    {
        this.errMsg = errMsg;
    } 
}
