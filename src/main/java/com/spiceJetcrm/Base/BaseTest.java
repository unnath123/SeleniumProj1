package com.spiceJetcrm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.spiceJetcrm.utils.Testutils;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\testProjects\\SeleniumProj1\\src\\main\\java\\com\\spiceJetcrm\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			//setup firefox
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Testutils.Page_Load));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Testutils.implicit_wait));
		
		driver.get(prop.getProperty("url"));
	}
}
