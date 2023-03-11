package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	public  static WebDriver driver;
	public static Properties prop;
	public static WebDriver initilizeDriver() throws IOException {


//		String browserName = "firefox"; --->Hard coding


		prop = new Properties();
		String propsPath = System.getProperty("user.dir")+"\\src\\main\\java\\base\\data.properties";
		FileInputStream fis = new FileInputStream(propsPath);
		prop.load(fis);


		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")) {

			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		return driver;
	}

}
