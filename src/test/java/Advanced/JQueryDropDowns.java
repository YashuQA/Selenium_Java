package Advanced;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.baseClass;

public class JQueryDropDowns extends baseClass {

	public static void main(String[] args) throws IOException {
		
		initilizeDriver();
		driver.get(prop.getProperty("dropDownJQueryURL"));
		//----------single selection-------------------------------
		WebElement singleSelectionDropDown = driver.findElement(By.id("justAnotherInputBox"));
		singleSelectionDropDown.click();
		driver.findElement(By.xpath("(//span[text()='choice 3'])[3]")).click();
		
		//------------multi selection--------------------------------
		
		WebElement multiSelectionDropDown = driver.findElement(By.id("justAnInputBox"));
		multiSelectionDropDown.click();
		/*
		 * driver.findElement(By.xpath("(//span[text()='choice 3'])[1]")).click();
		 * driver.findElement(By.xpath("(//span[text()='choice 2 2'])[1]")).click();
		 * driver.findElement(By.xpath("(//span[contains(text(),'choice 1  ')])[1]")).
		 * click();
		 */
		//------------to select all the options----------------------
		List<WebElement> options = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		for(WebElement e : options) {
			try {
			e.click();
			}catch(Exception ex) {
				break;
			}
		}
	}
}
