package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingEditText {
	/*
	 * For inputing text we use edit boxes
	 * represented by input tag - attribute - value=text
	 * input a value into an editbox - method - sendKeys() 
	 * */
	public WebDriver driver;
	
	public void launch() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/index.htm");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	public void text_to_EditBox(String x) {
		
		WebElement editBox = driver.findElement(By.xpath("//input[@id='search-strings']"));
		editBox.sendKeys(x);
		String l = editBox.getAttribute("value");
		System.out.println(l);
		WebElement btn = driver.findElement(By.id("btnSearch"));
		btn.click();
		
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		HandlingEditText obj = new HandlingEditText();
		obj.launch();
		obj.text_to_EditBox("Hello");

	}

}
