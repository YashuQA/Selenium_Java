package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.AddHasLaunchApp;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingRadioBtnAndCheckBoxes {

	public WebDriver driver;
	
	public void launch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.automationtestinginsider.com/2019/08/student-registration-form.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	public void radioBtn() throws InterruptedException {
		WebElement radio_btn = driver.findElement(By.xpath("//input[@type='radio' and @value='Female']"));
		radio_btn.click();
		System.out.println("Female radio button is selected:"+radio_btn.isSelected());
		Thread.sleep(2000);
	}
	public void check_Boxes(String hobby) throws InterruptedException {
		List<WebElement> list_Of_Checkboxes = 
				driver.findElements(By.xpath("//input[@type='checkbox' and @name='Hobby']"));
		for(int i = 0; i<list_Of_Checkboxes.size();i++) {
			WebElement webelement = list_Of_Checkboxes.get(i);
			String hobbies = webelement.getAttribute("value");
			if(hobbies.contains(hobby)) {
				webelement.click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	public void closebrowser() {
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		
		HandlingRadioBtnAndCheckBoxes obj = new HandlingRadioBtnAndCheckBoxes();
		obj.launch();
		obj.check_Boxes("Others");
		obj.closebrowser();

	}

}
