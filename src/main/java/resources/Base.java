package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
 public WebDriver initialmethd() throws IOException{
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chrome//chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return d;
 }
 public Properties getProperties() throws IOException{
	 String path=System.getProperty("user.dir")+"//src//main//java//gloabl.properties";
		FileInputStream fis=new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
 }
 
}
