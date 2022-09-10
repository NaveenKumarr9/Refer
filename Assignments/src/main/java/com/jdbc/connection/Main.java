package com.jdbc.connection;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Main {
	public static void main(String[] args) throws Exception   {

		 Data d = new Data();
		Properties p = new Properties();

		File file = new File("app.properties");
		
		p.load(new FileReader(file));
		
		Class.forName(d.decode(p.getProperty(d.getDriver())));
		
		Connection con = DriverManager.getConnection(d.decode(p.getProperty(d.getUrl())),
				d.decode(p.getProperty(d.getUsername())),d.decode(p.getProperty(d.getPassword())));
		
		System.out.println("connected");
		
		/*
		 * Statement st = con.createStatement(); 
		 * ResultSet rs = st.executeQuery("select * from student"); 
		 * rs.absolute(1);
		 * System.out.println(rs.getString(1)+" "+ rs.getInt(2));
		 */
		con.close();

	}

}
