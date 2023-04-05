package interviewQndAs;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class HandlingAjaxCalls extends BaseClass {
	/*
	 * Ajax Calls - 
	 * Why web pages makes these calls -
	 * Certain elements on the webpage gets load without expecting entire page to load
	 * 					those elements makes Ajax calls to server 
	 * Normal call to server like hitting url requires entire page to load 
	 * Ajax calls are only for few elements like clicking buttons which don't 
	 * 					expect entire page to load.
	 * AJAX allows web pages to be updated asynchronously by exchanging data with 
	 * 					a web server behind the scenes.
	 * AJAX means Asynchronous JavaScript And XML
	 * AJAX calls are one method to load personalized content separately from 
	 * 					the rest of the HTML document, which allows for the 
	 * 					full HTML document to be cached, improving back end load time.
	 * 
	 * But the problem with ajax call and selenium webdriver is - by using the waiting mechanism*/
	public static void main(String[] args) throws IOException {
		
		initilizeDriver();
		// a normal call is made to server - page will load until all the elements are loaded
		//url call is a synchronous call
		driver.get(prop.getProperty("omayo")); 
		
		driver.findElement(By.className("dropbtn")).click();
		//after the above click a ajax call is made to the server and webdriver cant wait till response
		
		//for normal calls selenium will wait till all the elements are loaded 
		//for ajax calls selenium will not wait
		
		//Ajax are asynchronous calls  - so implement waits
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		WebElement facebookOpt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
		
		facebookOpt.click();
		
		

	}

}
