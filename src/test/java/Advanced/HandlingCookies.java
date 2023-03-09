package Advanced;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	/*
	 * HTTP Cookie = user info + their preferences Used to communicate between
	 * different web pages. Purpose of cookies is rapid interactions between pages.
	 * Also called as user's identity. Stores in the form of Key-value pairs(text
	 * file) A cookie is a small piece of information that is stored in a text file
	 * on user’s (client) hard drive by the web server. It happenes while the user
	 * is browsing that website. Cookies consists of 1. name of the server the
	 * cookie was sent 2.Cookies LifeTime 3.A Value(randomly generated unique
	 * number)
	 * 
	 * Types of Cookies : 1.Session Cookies(Browser is closed the session will be
	 * closed) 2.Persistent Cookies(permanently written on the user machine it lasts
	 * for months or years)
	 * 
	 * driver.manage().getCookies(); ---> Return the list of all cookies.
	 * driver.manage().getCookieName(arg0); ---> Return specific cookie according to
	 * the name driver.manage().addCookie(arg0); ---> Create and add the cookie
	 * driver.manage().deleteCookie(arg0); --->Delete specific cookie
	 * driver.manage().deletedCookieName(arg0); --->Delete specific cookie according
	 * name driver.manage().deleteAllCookies(); --->Delete all cookies
	 * 
	 * Why handle cookies in selenium? 1.When Testing a web application using
	 * selenium web driver, you may need to create, update or delete a cookie. 2.If
	 * cookies are not stored, you will need to perform login action every time
	 * before you execute above listed test scenarios. This will increase your
	 * coding effort and execution time. Solution is to sstore these cookies in file
	 * and later retrieve the values of cookies from their file and add to it your
	 * current browser session has this information in it.
	 *
	 */
	public static void main(String[] args) throws InterruptedException {

		// Storing cookie information

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

//		driver.get("https://demo.guru99.com/test/cookie/selenium_aut.php");
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("yashuqa001@gmail.com");
		driver.findElement(By.name("password")).sendKeys("yashu12345!");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		

		// create file named cookies to store login information
		File file = new File("Cookies.data");

		try {
			// delete old file if exists
			file.delete();
			file.createNewFile();
			//store cookie info using FileWriter class to write streams of character
			FileWriter fileWrite = new FileWriter(file);
			//BufferedWriter is to write into a file to create into a file Cookies.data
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);

			// loop for getting the cookie information
		
			for ( Cookie ck : driver.manage().getCookies()) {

				Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				Bwrite.newLine();
			}
			Bwrite.close();
			fileWrite.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
