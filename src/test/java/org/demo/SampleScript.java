package org.demo;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SampleScript extends BaseClass{

		public static void main(String[] args) throws IOException, InterruptedException  {
			BaseClass base = new BaseClass();
			base.getDriver("Chrome");
			base.winMax();
			base.launchUrl((base.readExcel(9, 1)));
			base.screenCapture();
			WebElement loginPage = driver.findElement(By.xpath("//td[@class='login_title']"));
			String text = loginPage.getText();
			System.out.println("Launched the adactin login "+text+ " page successfully");
			WebElement username = driver.findElement(By.id("username"));
			base.sendKeysByJava(username, base.readExcel(0, 1));
			WebElement password = driver.findElement(By.id("password"));
			base.sendKeysByJava(password, base.readExcel(1, 1));
			WebElement loginButton = driver.findElement(By.id("login"));
			base.clickByJava(loginButton);
			base.screenCapture();
			WebElement validateSearchHotelPage = driver.findElement(By.xpath("//td[@class='login_title']"));
			String text2 = validateSearchHotelPage.getText();
			System.out.println("Logged into " +text2+ " successfully");
			WebElement location = driver.findElement(By.id("location"));
			base.selectByText(location, "Sydney");
			WebElement hotels = driver.findElement(By.id("hotels"));
			base.selectByText(hotels, "Hotel Sunshine");
			WebElement roomType = driver.findElement(By.id("room_type"));
			base.selectByText(roomType, "Deluxe");
			WebElement roomNo = driver.findElement(By.id("room_nos"));
			base.selectByText(roomNo, "2 - Two");
			WebElement checkInDate = driver.findElement(By.id("datepick_in"));
			base.sendKeysByJava(checkInDate, base.readExcel(2, 1));
			WebElement checkOutDate = driver.findElement(By.id("datepick_out"));
			base.sendKeysByJava(checkOutDate, base.readExcel(3, 1));
			WebElement adultRoom = driver.findElement(By.id("adult_room"));
			base.selectByText(adultRoom, "2 - Two");
			WebElement childRoom = driver.findElement(By.id("child_room"));
			base.selectByText(childRoom, "1 - One");
			WebElement searchButton = driver.findElement(By.id("Submit"));
			base.clickByJava(searchButton);
			WebElement selectHotelPage = driver.findElement(By.xpath("//td[@class='login_title']"));
			String text3 = selectHotelPage.getText();
			System.out.println("Entered into "+text3+" page successfully");
			base.screenCapture();
			WebElement radioButton = driver.findElement(By.id("radiobutton_0"));
			base.clickByJava(radioButton);
			WebElement continueButton = driver.findElement(By.id("continue"));
			base.clickByJava(continueButton);
			WebElement bookAHotelPage = driver.findElement(By.xpath("(//td[@class='login_title'])[2]"));
			String text4 = bookAHotelPage.getText();
			System.out.println("Entered into "+text4+" page successfully");
			base.screenCapture();
			WebElement firstName = driver.findElement(By.id("first_name"));
			base.sendKeysByJava(firstName, base.readExcel(4, 1));
			WebElement lastName = driver.findElement(By.id("last_name"));
			base.sendKeysByJava(lastName, base.readExcel(5, 1));
			WebElement address = driver.findElement(By.id("address"));
			base.sendKeysByJava(address, base.readExcel(6, 1));
			WebElement ccNum = driver.findElement(By.id("cc_num"));
			base.sendKeysByJava(ccNum, base.readExcel(7, 1));
			WebElement ccType = driver.findElement(By.id("cc_type"));
			base.selectByText(ccType, "Master Card");
			WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
			base.selectByText(ccExpMonth, "July");
			WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
			base.selectByText(ccExpYear, "2029");
			WebElement cvvNum = driver.findElement(By.id("cc_cvv"));
			base.sendKeysByJava(cvvNum, base.readExcel(8, 1));
			WebElement bookNow = driver.findElement(By.id("book_now"));
			base.clickByJava(bookNow);
			base.sleep(5000);
			WebElement bookingConfirmation = driver.findElement(By.xpath("//td[@class='login_title']"));
			String text5 = bookingConfirmation.getText();
			System.out.println("Successfully entered into "+text5+" page");
			base.screenCapture();
			WebElement myItinerary = driver.findElement(By.id("my_itinerary"));
			base.clickByJava(myItinerary);
			WebElement cancel = driver.findElement(By.id("btn_id_1261546"));
			base.clickByJava(cancel);
			base.handleAlert();
			base.screenCapture();
			WebElement logoutButton = driver.findElement(By.xpath("//a[@href='Logout.php']"));
			base.clickByJava(logoutButton);
			base.screenCapture();
			WebElement againLogin = driver.findElement(By.xpath("//a[@href='index.php']"));
			base.clickByJava(againLogin);
			base.screenCapture();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

	}
}
