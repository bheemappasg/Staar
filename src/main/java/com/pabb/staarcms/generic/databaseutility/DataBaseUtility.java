package com.pabb.staarcms.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	public void getDbconnection(String url,String username, String password) throws SQLException
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	  con= DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{	
		}}
		public void getDbconnection() throws SQLException
		{
			try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
		  con= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			}
			catch(Exception e)
			{
				
			}}
		public void closeConnection() throws SQLException
		{
			try {
			con.close();
			}
			catch(Exception e)
			{
				
			}
		}
			public ResultSet executeSelectQuery(String query) {
				
			ResultSet set=null;
			try
			{
			Statement stat = con.createStatement();
			set = stat.executeQuery(query);
			}
			catch(Exception e)
			{
				
			}
		return set;
		}
		

}
