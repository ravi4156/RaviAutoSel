package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtil {
	public static String getProperty(String path,String key){
	String v="";
	
	Properties p=new Properties();
	try {
		p.load(new FileInputStream(path));
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	v=p.getProperty(key);
			return v;
	}

	public static void getPhoto(WebDriver driver, String folder, String FileName) {
		String dateTime=new Date(0).toString().replaceAll(":", "_");
		String path=folder+FileName+dateTime+".png";
		TakesScreenshot t=(TakesScreenshot)driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
		
}
			

