package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsByTagName {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demoqa.com/text-box/");
		driver.manage().window().maximize();
		
		List<WebElement> listOfInputTags = driver.findElements(By.tagName("input"));
		
		if(listOfInputTags.size()!=0) {
			System.out.println(listOfInputTags.size()+" elements found by tag name as Input.");
			
			for(WebElement inputElement:listOfInputTags) {
				System.out.println("Input Element :"+inputElement.getAttribute("placeholder"));
			}
		}
		
		driver.quit();

	}

}
