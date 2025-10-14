package com.hannaford.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
  public static WebDriver driver;
  JavascriptExecutor executor;
  TakesScreenshot screenshot;
  

  public void createCellAndSetData(String sheetName, int rownum, int cellnum, String data, String filename) throws IOException {
    File file = new File("C:\\Users\\kumar\\eclipse-workspace\\rohit1\\FrameworkClass\\Excel\\"+filename+".xlsx");
    FileInputStream fileInputStream = new FileInputStream(file);
    Workbook workbook = new XSSFWorkbook(fileInputStream);
    Sheet sheet = workbook.getSheet(sheetName);
    Row row = sheet.getRow(rownum);
    Cell cell = row.createCell(cellnum);
    cell.setCellValue(data);
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    workbook.write(fileOutputStream);

  }

  public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData, String filename)
      throws IOException {
    File file = new File("C:\\Users\\kumar\\eclipse-workspace\\rohit1\\FrameworkClass\\Excel\\"+filename+".xlsx");
    FileInputStream fileInputStream = new FileInputStream(file);
    Workbook workbook = new XSSFWorkbook(fileInputStream);
    Sheet sheet = workbook.getSheet(sheetName);
    Row row = sheet.getRow(rownum);
    Cell cell = row.getCell(cellnum);
    DataFormatter dataFormatter = new DataFormatter();
    String formatCellValue = dataFormatter.formatCellValue(cell);
    if (formatCellValue.equals(oldData)) {
      cell.setCellValue(newData);
    }
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    workbook.write(fileOutputStream);
  }

  public String getCellData(String sheetName, int rownum, int cellnum, String filename) throws IOException {
    File file = new File("C:\\Users\\kumar\\eclipse-workspace\\rohit1\\FrameworkClass\\Excel\\"+filename+".xlsx");
    FileInputStream fileInputStream = new FileInputStream(file);
    Workbook workbook = new XSSFWorkbook(fileInputStream);
    Sheet sheet = workbook.getSheet(sheetName);
    Row row = sheet.getRow(rownum);
    Cell cell = row.getCell(cellnum);
    DataFormatter dataFormatter = new DataFormatter();
    String formatCellValue = dataFormatter.formatCellValue(cell);
    return formatCellValue;
  }

  public void switchToChildWindow() {
    String parentWindow = driver.getWindowHandle();
    Set<String> allWindows = driver.getWindowHandles();
    for (String eachWindow : allWindows) {
      if (!parentWindow.equals(eachWindow)) {
        driver.switchTo().window(eachWindow);
        break;
      }
    }
  }

  public List<String> getAllOptions(WebElement element) {
    List<String> allOptionsText = new ArrayList();
    Select select = new Select(element);
    List<WebElement> options = select.getOptions();
    for (WebElement webElement : options) {
      allOptionsText.add(webElement.getText());

    }
    return allOptionsText;

  }
  
  public List<String> printAllOptions(List<WebElement> element) {
	      List<String> text = new ArrayList();
	  for (WebElement eachElement : element) {
	      String text2 = eachElement.getText();
	      System.out.println(text2);
	    }
	    return text;

	  }
  
  public String printOptions(List<WebElement> element) {
     
	  for (WebElement eachElement : element) {
		  String text = eachElement.getText();
		  System.out.println(text);

	  }
	  return null;
    }
  

  public void selectAllEnabledOptions(WebElement element) {
	    Select select = new Select(element);
	    List<WebElement> options = select.getOptions();
	    for (WebElement option : options) {
	    	if(option.isEnabled()) {
	    	   select.selectByVisibleText(option.getText());
	    	}
	    }
	    }
	    
  public void selectAllOptionsByIndex(WebElement element) {
	    Select select = new Select(element);
	    List<WebElement> options = select.getOptions();
	    for (int i=0; i<options.size(); i++) {
	      select.selectByIndex(i);
	    }
	    }
  
  
  public void navigateTo(String url) {
    driver.navigate().to(url);
  }
  
  public void navigateForward() {
	driver.navigate().forward();
  }
  
  public void navigateBacward() {
	driver.navigate().back();
  }
  
  public void navigateRefresh() {
  driver.navigate().refresh();
  }

  public void screenshot(String fileName, WebElement element) throws IOException {
    File s = element.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(s,
        new File("C:\\Users\\Velmurugan\\eclipse-workspace\\FrameworkClass1030AM\\images\\" + fileName + ".png"));
  }

  public void screenshot(String fileName) throws IOException {
    screenshot = (TakesScreenshot) driver;
    File s = screenshot.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(s,
        new File("C:\\Users\\Velmurugan\\eclipse-workspace\\FrameworkClass1030AM\\images\\" + fileName + ".png"));
  }
  
  public byte[] screenshotInByteFormat() {
	  screenshot = (TakesScreenshot) driver;
	  byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
	  return bs;
  }
  
  public void deleteBrowserCookies() {
	  driver.manage().deleteAllCookies();
  }

  public void elementVisibilityOf(WebElement element) {
	 WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 driverWait.until(ExpectedConditions.visibilityOf(element));

  }
  
  
  public void elementToBeClickable(WebElement element) {
	 WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 driverWait.until(ExpectedConditions.elementToBeClickable(element));

  }

  public static void implicitwait() {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }

	  public static void implicitwait(int secs) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	  }

	  public void selectOptionByText(WebElement element, String text) {
	    Select select = new Select(element);
	    select.selectByVisibleText(text);
	  }

	  public void selectOptionByValue(WebElement element, String text) {
	    Select select = new Select(element);
	    select.selectByValue(text);
	  }

	  public void selectOptionByIndex(WebElement element, int index) {
	    Select select = new Select(element);
	    select.selectByIndex(index);
	  }
	  
	  public String firstSelectedOption(WebElement element) {
		Select select = new Select(element);
		String text = select.getFirstSelectedOption().getText();
		return text;
	  }
	  
	  public boolean isMultiSelected(WebElement element) {
			Select select = new Select(element);
			boolean ismultiple = select.isMultiple();
			return ismultiple;
	  }
	  
	  public void deselectAll(WebElement element) {
		    Select select = new Select(element);
		    select.deselectAll();
	  }
	  
	  public void clearValues(WebElement element) {
		    element.clear();
	  }
	  
	  public static void chromeBrowserLaunch() {
	    driver = new ChromeDriver();
	  }
	  
	  public static void fireFoxBrowserLaunch() {
		    driver = new FirefoxDriver();
	  }
	  
	  public static void edgeBrowserLaunch() {
		    driver = new EdgeDriver();
	  }

	  public static void enterApplUrl(String url) {
	    driver.get(url);
	  }

	  public static void maximizeWindow() {
	    driver.manage().window().maximize();
	  }

	  public void elementSendKeys(WebElement element, String data) {
	    elementVisibilityOf(element);
	    if (elementDisplayed(element) && elementIsEnabled(element)) {
	      element.sendKeys(data);
	    }
	  }
	  
	  public void elementSendKeysEnter(WebElement element, String data) {
		elementVisibilityOf(element);
		if (elementDisplayed(element) && elementIsEnabled(element)) {
		  element.sendKeys(data, Keys.ENTER);
		}
	  }

	  public void elementSendKeysJs(WebElement element, String data) {
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	  }
	  
	  public void elementClickJs(WebElement element) {
		    JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].click()", element);
	  }
	  
	  public void scrollDownJs(WebElement element) {
		    JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].scrollIntoView(true)", element);
	  }
	  
	  public void scrollUpJs(WebElement element) {
		    JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].scrollIntoView(false)", element);
	  }

	  public void elementClick(WebElement element) {
	    elementVisibilityOf(element);
	    if (elementDisplayed(element) && elementIsEnabled(element)) {
	      element.click();
	    }
	  }

	  public String getApplnTitle() {
	    String title = driver.getTitle();
	    return title;
	  }

	  public String getApplnUrl() {
	    String currentUrl = driver.getCurrentUrl();
	    return currentUrl;
	  }

	  public WebElement findLocatorById(String attributeValue) {
	    WebElement element = driver.findElement(By.id(attributeValue));
	    return element;
	  }

	  public WebElement findLocatorByName(String attributeValue) {
	    WebElement element = driver.findElement(By.name(attributeValue));
	    return element;
	  }

	  public WebElement findLocatorByClassName(String attributeValue) {
	    WebElement element = driver.findElement(By.className(attributeValue));
	    return element;
	  }

	  public WebElement findLocatorByXpath(String xpathExp) {
	    WebElement element = driver.findElement(By.xpath(xpathExp));
	    return element;
	  }
	  
	  public List<WebElement> findElementsByXpath(String xpathExp) {

		  List<WebElement> elements = driver.findElements(By.xpath(xpathExp));
		return elements;
		  }

	  public static void closeBrowser() {
	    driver.close();
	  }
	  
	  public static void quitBrowser() {
		driver.quit();
	  }

	  public String elementGetText(WebElement element) {
	    elementVisibilityOf(element);

	    String text = element.getText();
	    return text;
	  }

	  public String elementGetDomProperty(WebElement element) {
	    elementVisibilityOf(element);

	    String domProperty = element.getDomProperty("value");
	    return domProperty;
	  }

	  public String elementGetDomProperty(WebElement element, String attributeName) {
	    elementVisibilityOf(element);

	    String domProperty = element.getDomProperty(attributeName);
	    return domProperty;
	  }

	  public boolean elementDisplayed(WebElement element) {
	    elementVisibilityOf(element);

	    boolean displayed = element.isDisplayed();
	    return displayed;
	  }

	  public boolean elementIsEnabled(WebElement element) {
	    elementVisibilityOf(element);

	    boolean enabled = element.isEnabled();
	    return enabled;
	  }

	  public boolean elementISelected(WebElement element) {
	    elementVisibilityOf(element);

	    boolean selected = element.isSelected();
	    return selected;
	  }
	  
	  public void mouseOverAction(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();  
	  }
	  
	  public void dragAndDrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).perform();  
	  }
	  
	  public void RightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();  
	  }
	  
	  public void DoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();  
	  }
	  
	  public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();		
	  }
	  
	  public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();	
	  }
	  
	  public void switchToFrameByIndex(int index) {
		  driver.switchTo().frame(index);
	  }
	  
	  public void switchToFrameById(String attributeValue) {
		  driver.switchTo().frame(attributeValue);
	  }
	  
	  public void switchToFrameByName(String attributeValue) {
		  driver.switchTo().frame(attributeValue);
	  }
	  
	  public void switchToDefaultContent() {
		  driver.switchTo().defaultContent();
	  }
	  
	  }

