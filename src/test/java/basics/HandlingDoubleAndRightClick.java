package basics;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class HandlingDoubleAndRightClick extends BaseClass{
 
	public static void main(String[] args) throws IOException, InterruptedException {
		
		initilizeDriver();
		driver.get(prop.getProperty("web_Elements"));
		Thread.sleep(2000);
		
		WebElement double_Click = driver.findElement(By.id("doubleClickBtn"));
		WebElement right_Click = driver.findElement(By.id("rightClickBtn"));
		
		Actions action = new Actions(driver);
		
		action.doubleClick(double_Click).perform();
		System.out.println("Double Click Performed!");
		
		Thread.sleep(2000);
		
		//driver.switchTo().alert().accept();
		
		boolean presentFlag = false;
		
		try {
		Alert alert = driver.switchTo().alert();
		presentFlag = true;
		alert.accept();
		}catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
//		Thread.sleep(2000);
//		
//		action.contextClick(right_Click).perform();
//		
//		Thread.sleep(2000);
//		
//		driver.close();
	
	}

}
