package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import ConstantData.constantData;



public class FetchDataFromProperty {
	public static Properties properties;
	
	public static Properties readDataFromProperty() throws IOException
	{
		FileReader reader=new FileReader(constantData.PropertyFilePath);
		Properties properties=new Properties();
		properties.load(reader);
		return properties;
		
		
	}
	
	public static String getUsername()
	{
		String username = properties.getProperty("uname");
		if(username!=null)
			return username;
		else
			throw new RuntimeException("username not specified in config file.");
		
	}

	public static String getPassword()
	{
		String password = properties.getProperty("pwd");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}

}
