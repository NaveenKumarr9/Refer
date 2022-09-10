package com.encode.decode;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Main {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String code = "org.mariadb.jdbc.Driver";
		
		String encode = Base64.getEncoder().encodeToString(code.getBytes("UTF-8"));
		System.out.println(encode);
		
		byte[] decode = Base64.getDecoder().decode(encode);
		String decodeString = new String(decode,"UTF-8");
		System.out.println(decodeString);
		
	}

}
