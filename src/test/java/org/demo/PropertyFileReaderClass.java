package org.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyFileReaderClass {
  public static void main(String[] args) throws IOException {
	Properties prop = new Properties();
	
	//To locate the property file where it needs to be located
	FileReader reader = new FileReader("C:\\Users\\sindh\\eclipse-workspace\\Frames\\DataBase\\Config.properties");
	
	//To load property files into property class
	prop.load(reader);
	
	//To get values based on key in String
	Object object = prop.get("url");
	System.out.println(object);
	
	//String url = prop.getProperty("url");
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get(prop.getProperty("url"));
	
}
}
