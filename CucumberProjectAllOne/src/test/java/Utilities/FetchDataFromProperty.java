package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Constants.AllConstants;

public class FetchDataFromProperty {

	public static Properties fetchdatafromPropertyMethod() throws IOException
	{
		FileReader reader=new FileReader(AllConstants.PropertyfilePath);
		Properties pro=new Properties();
		pro.load(reader);
		
		return pro;
		
	}
	
}
