package com.jdbc.connection;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Data {

	private String driver = "driver_name";
	private String username = "username";
	private String password = "password";
	private String url = "url";

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String decode(String encoded) throws UnsupportedEncodingException {

		byte[] decode = Base64.getDecoder().decode(encoded);
		String decodedString = new String(decode, "UTF-8");
		return decodedString;
	}
}
