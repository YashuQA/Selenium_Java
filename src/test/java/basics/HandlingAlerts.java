package basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlerts {

	/*
	 * -------Handling Alert---------------
	 * Alert -- Pop-ups
	 * We need to switch from main window to pop-up window. For that we use switchTo() method.
	 * As selenium can only focus on single window at a time.
	 * 
	 * Alert interface is having couple of methods
	 * accept() -- To click ok or accept the alert
	 * dismiss() -- To cancel the alert
	 * getText() -- To get Text from an alert
	 * sendKeys() -- To send some input to an alert
	*/
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		driver.findElement(By.id("alert1")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

}
