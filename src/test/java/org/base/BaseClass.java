package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor javascriptExecutor;
	public static Select select;
	public static Actions actions;

	public static void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("InValid_BrowserType");
			break;
		}
	}

	public static void winMax() {

		driver.manage().window().maximize();

	}

	public void launchUrl(String browserUrl) {
		driver.get(browserUrl);

	}

	public void sendKeysByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);

	}

	public void sendKeysByJS(WebElement element, String keysToSend) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);

	}

	public void clickByJS(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);

	}

	public void scrollByJS(WebElement element, String scrollType) {
		javascriptExecutor = (JavascriptExecutor) driver;

		switch (scrollType) {
		case "Up":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", element);
			break;

		case "Down":
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
			break;

		default:
			System.out.println("InValid_ScrollType");
			break;
		}

	}

	public void actionDragAndDrop(WebElement source, WebElement target) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
		// actions.clickAndHold(source).release(target).build().perform();

	}

	public void windowsHandling(int childWindowIndex) {

		String parentWindowsID = driver.getWindowHandle();
		Set<String> allWindowsID = driver.getWindowHandles();

		// To Create Empty List
		List<String> list = new LinkedList<String>();
		// ADd all the Set value(WindowsID) into List
		list.addAll(allWindowsID);

		// To get Required ChildWindosID based on Index
		String childWindowsID = list.get(childWindowIndex);
		// To switch to required windows
		driver.switchTo().window(childWindowsID);

	}

	public String getWindowsID(int childWindowIndex) {

		String parentWindowsID = driver.getWindowHandle();
		Set<String> allWindowsID = driver.getWindowHandles();

		// To Create Empty List
		List<String> list = new LinkedList<String>();
		// ADd all the Set value(WindowsID) into List
		list.addAll(allWindowsID);

		// To get Required ChildWindosID based on Index
		String childWindowsID = list.get(childWindowIndex);

		return childWindowsID;

	}

	public void switchToWindows(String childWindowsID) {
		driver.switchTo().window(childWindowsID);

	}

	public void clickByJava(WebElement element) {
		element.click();

	}

	public void screenCapture() throws IOException {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("C:\\Users\\sindh\\eclipse-workspace\\Frames\\ErrorScreenshot\\"
				+ System.currentTimeMillis() + ".jpeg");
		FileUtils.copyFile(screenshotAs, targetFile);

	}

	public void navigation(String commands) {

		switch (commands) {
		case "refresh":
			driver.navigate().refresh();
			break;

		case "forward":
			driver.navigate().forward();
			break;

		case "back":
			driver.navigate().back();
			;
			break;

		default:
			System.out.println("InValid_Commands");
			break;
		}

	}

	public void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void gettingText() {
		
		
	}
     public void handleAlert() {
    	 Alert alert = driver.switchTo().alert();
    	 alert.accept();
    	 
	}
	public void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}

	public String readExcel(int rownum, int cellnum) throws IOException {

		// To locate File
		File file = new File(
				"C:\\Users\\sindh\\eclipse-workspace\\Frames\\DataBase\\JB.xlsx");

		FileInputStream fileInputStream = new FileInputStream(file); // throws FileNotFoundException

		// To Define Workbook
		Workbook workbook = new XSSFWorkbook(fileInputStream); // throws IOException

		// To get sheet from workbook
		Sheet sheet = workbook.getSheet("Sheet1");

		// To get Row from sheet
		Row row = sheet.getRow(rownum);

		// To get Cell from Row
		Cell cell = row.getCell(cellnum);

		// To Find Cell Type
		CellType cellType = cell.getCellType();

		String value = null;

		switch (cellType) {
		case STRING:

			value = cell.getStringCellValue();

			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				value = simpleDateFormat.format(dateCellValue);

			} else {

				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				value = valueOf.toString();

			}

			break;

		default:
			break;
		}

		return value;

	}
	
	

}