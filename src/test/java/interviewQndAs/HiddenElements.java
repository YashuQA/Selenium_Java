package interviewQndAs;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import base.BaseClass;

public class HiddenElements extends BaseClass{

	/*
	 * Actually when we try to handle hidden elements on a web page we get expections
	 * Exceptions of kind : ElementNotVisible Exception
	 * 						ElementNotInteractable Exception
	 * So we need to use JavaScriptExecutor*/
	public static void main(String[] args) throws IOException, InterruptedException {
		
		initilizeDriver();
		driver.get(prop.getProperty("letskodeit"));
		driver.findElement(By.id("hide-textbox")).click(); // hides the input box
		/*
		driver.findElement(By.id("displayed-text")).sendKeys("Yashu"); // for this to happen input box will not be there
		//we will get ElementNotInteractableException - So we will be running the JavaScript code.
		*/
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('displayed-text').value='Yashu';");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("show-textbox")).click();
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
