package advanced;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import base.BaseClass;

public class AlertsDisplayIssue extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException {

		initilizeDriver();
		driver.get(prop.getProperty("alertsDisplayIssueURL"));
		driver.findElement(By.xpath("//button[contains(.,'Click for JS Prompt')]")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Hey JS Prompt!");
		alert.accept();
		Thread.sleep(3000);
		driver.quit();
		

	}

}
