package com.pabb.staarcms.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author bheem
 * this class contains method like getDatafromProperties 
 */
public class FileUtility {
	/*this method is used to get the comman data from properties file  */
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop\\StaarCms.Properties");
		Properties p =new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;  
	}

}
