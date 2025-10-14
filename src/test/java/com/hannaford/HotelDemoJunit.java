package com.hannaford;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hannaford.baseclass.BaseClass;


public class HotelDemoJunit extends BaseClass{
	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		
	chromeBrowserLaunch();
	maximizeWindow();
	enterApplUrl("https://www.omrbranch.com/");
	implicitwait(5);
	
	}
	
	@Test
	public void testCaseLogin() throws InterruptedException {
	
	WebElement txtEmailId = findLocatorById("email");
	elementSendKeys(txtEmailId, "18a123rohithkumar@gmail.com");
	
	WebElement txtPassword = findLocatorById("pass");
	elementSendKeysEnter(txtPassword, "Rohith@2000");
	
	WebElement btnLogin = findLocatorByXpath("//button[text()='Login']");
	elementClick(btnLogin);
	
	WebElement welcomeRohithText = findLocatorByXpath("//a[contains(text(),'Welcome Rohith')]");
	System.out.println(elementGetText(welcomeRohithText));
	
	WebElement optionState = findLocatorById("state");
	selectOptionByText(optionState, "Tamil Nadu");
    
	WebElement optionCity = findLocatorById("city");
	selectOptionByText(optionCity, "Chennai");
	
	WebElement optionRoomtype = findLocatorById("room_type");
	selectAllEnabledOptions(optionRoomtype);
    
	WebElement checkInDate = findLocatorByXpath("//input[@name='check_in']");
	elementClick(checkInDate);
	Thread.sleep(600);
	WebElement date28 = findLocatorByXpath("//td/a[text()='28']");
	elementClickJs(date28);
	
	WebElement checkOutDate = findLocatorByXpath("//input[@name='check_out']");
	elementClick(checkOutDate);
	Thread.sleep(600);
	WebElement date31 = findLocatorByXpath("//td/a[text()='31']");
	elementClickJs(date31);
	
	WebElement optionNoOfRooms = findLocatorById("no_rooms");
	selectOptionByText(optionNoOfRooms, "3-Three");
	
	WebElement optionNoOfAdults = findLocatorById("no_adults");
	selectOptionByText(optionNoOfAdults, "2-Two");
	
	WebElement optionNoOfChild = findLocatorById("no_child");
	elementSendKeysEnter(optionNoOfChild, "1");
	
	switchToFrameById("hotelsearch_iframe");
	
	WebElement btnSearch = findLocatorById("searchBtn");
	elementClickJs(btnSearch);
	
	switchToDefaultContent();
	
	WebElement selectHotelText = findLocatorByXpath("//div//div//section//div//div//div//div//h5[text()='Select Hotel']");
	System.out.println(elementGetText(selectHotelText));
	
	List<WebElement> hotelNamesText = findElementsByXpath("//div[@class='col-md-5 hotel-suites']/h5");	
	printAllOptions(hotelNamesText);
	
	List<WebElement> priceWithTax = findElementsByXpath("//div[@class='prize']//strong");
	printAllOptions(priceWithTax);
	
	List<WebElement> priceWithoutTax = findElementsByXpath("//div[@class='prize']//h2");
	printAllOptions(priceWithoutTax);
	
	WebElement btnContinue = findLocatorByXpath("(//a[text()='Continue'])[3]");
	elementClick(btnContinue);
	
	alertAccept();
	
	WebElement bookHotelText = findLocatorByXpath("//div//h2[contains(text(),'Book Hotel -')]");
	String elementGetText = elementGetText(bookHotelText);
	System.out.println(elementGetText.replace("Book Hotel - ", ""));
	
	WebElement rdoOwn = findLocatorById("own");
	elementClick(rdoOwn);
	
	WebElement optionSalutation = findLocatorById("user_title");
	selectOptionByText(optionSalutation, "Mr.");
	
	WebElement txtFirstName = findLocatorById("first_name");
	elementSendKeys(txtFirstName, "John");
	
	WebElement txtLastName = findLocatorById("last_name");
	elementSendKeys(txtLastName, "Mathew");
	
	WebElement txtphone = findLocatorById("user_phone");
	elementSendKeys(txtphone, "7355720048");
	
	WebElement txtEmail = findLocatorById("user_email");
	elementSendKeys(txtEmail, "johnmathew@gmail.com");
	
	WebElement btnGST = findLocatorById("gst");
	elementClick(btnGST);
	
	WebElement txtRegNoGST = findLocatorById("gst_registration");
	elementSendKeys(txtRegNoGST, "9043592058");
	
	WebElement txtCompanyName = findLocatorById("company_name");
	elementSendKeys(txtCompanyName, "Greens Tech OMR Branch");
	
	WebElement txtCompanyAddress = findLocatorById("company_address");
	elementSendKeys(txtCompanyAddress, "Thoraipakkam");
	
	WebElement btnNext = findLocatorById("step1next");
	elementClick(btnNext);
	
	WebElement btnLargeBed = findLocatorById("bed");
	elementClick(btnLargeBed);
	
	WebElement txtRequest = findLocatorById("other_request");
	elementSendKeys(txtRequest, "Extra Pillows and Blankets");
	
	WebElement btnNext2 = findLocatorById("step2next");
	elementClick(btnNext2);
	
	WebElement paymentOption = findLocatorByXpath("//div[@class='credit-card pm']");
	elementClick(paymentOption);
	
	WebElement optionPayment = findLocatorById("payment_type");
	selectOptionByText(optionPayment, "Debit Card");
	
	WebElement optionCard = findLocatorById("card_type");
	selectOptionByText(optionCard, "Visa");
	
	WebElement txtCardNo = findLocatorById("card_no");
	elementSendKeys(txtCardNo, "5555555555552222");
	
	WebElement txtCardName = findLocatorById("card_name");
	elementSendKeys(txtCardName, "John");
	
	WebElement optionCardMonth = findLocatorById("card_month");
	selectOptionByText(optionCardMonth, "October");
	
	WebElement optionCardYear = findLocatorById("card_year");
	selectOptionByText(optionCardYear, "2028");
		
	WebElement txtCVV = findLocatorById("cvv");
	elementSendKeys(txtCVV, "123");
	
	WebElement btnSubmit = findLocatorById("submitBtn");
	elementClick(btnSubmit);
	
	Thread.sleep(3000);
	
	WebElement textBookingId = findLocatorByXpath("//div//h2//strong[contains(text(),'#')]");
	String bookingId = elementGetText(textBookingId);
	System.out.println(bookingId.replace("#", ""));
	
	WebElement textBookingConfirm = findLocatorByXpath("//h2[text()=' Booking is Confirmed ']");
	String bookingConfirm = textBookingConfirm.getText();
	System.out.println(bookingConfirm.substring(12));	
	
	WebElement textHotelName = findLocatorByXpath("//div//p//strong[contains(text(),'Chennai')]");
	System.out.println(textHotelName.getText());
	
	WebElement btnMyBooking = findLocatorByXpath("//button[text()='My Booking']");
	elementClick(btnMyBooking);

	WebElement textBookingId2 = findLocatorByXpath("//a//span[contains(text(),'#')]");
	String bookingId2 = elementGetText(textBookingId2);
	String replaceBookingId2 = bookingId2.replace("#", "");
	System.out.println(replaceBookingId2);
	
	WebElement txtBookingNo = findLocatorByXpath("//input[@name='search']");
	elementSendKeysEnter(txtBookingNo, replaceBookingId2);
	
	WebElement textHotelName2 = findLocatorByXpath("//a//h5[contains(text(),'Chennai')]");
	System.out.println(textHotelName2.getText());
	
	WebElement textHotelPrice = findLocatorByXpath("//div//strong[@class='total-prize']");
	System.out.println(textHotelPrice.getText());
	
	
//	WebElement btnEdit = null;
//	for (int i = 0; i < 3; i++) {
//	    try {
//	        WebElement btnEdit = findLocatorByXpath("//button[text()='Edit']");
//	        elementClick(btnEdit);
//	        break;
//	    } catch (StaleElementReferenceException e) {
//	        
//	    }
//	}
	Thread.sleep(2000);
	findLocatorByXpath("//button[text()='Edit']").click();
	
	WebElement modifyCheckInDate = findLocatorByXpath("//input[@name='check_in']");
	elementClick(modifyCheckInDate);
	Thread.sleep(600);
	WebElement modifyInDate = findLocatorByXpath("//td/a[text()='28']");
	elementClickJs(modifyInDate);
	
	WebElement modifyCheckOutDate = findLocatorByXpath("//input[@name='check_out']");
	elementClick(modifyCheckOutDate);
	Thread.sleep(600);
	WebElement modifyOutDate = findLocatorByXpath("//td/a[text()='30']");
	elementClickJs(modifyOutDate);
	Thread.sleep(1000);
	WebElement btnConfirm = findLocatorByXpath("//button[text()='Confirm']");
	elementClickJs(btnConfirm);
	
	Thread.sleep(600);
	WebElement txtUpdatedBooking = findLocatorByXpath("//ul//li[@class='alertMsg']");
	System.out.println(txtUpdatedBooking.getText());
	
//	WebElement btnMyBooking2 = findLocatorById("step2");
//	elementClick(btnMyBooking2);
	
	WebElement textBookingId3 = findLocatorByXpath("//a//span[contains(text(),'#')]");
	String bookingId3 = elementGetText(textBookingId3);
	String replaceBookingId3 = bookingId3.replace("#", "");
	System.out.println(replaceBookingId3);
	
//	WebElement txtBookingNo2 = findLocatorByXpath("//input[@name='search']");
//	elementSendKeysEnter(txtBookingNo2, replaceBookingId3);
	
	WebElement textHotelName3 = findLocatorByXpath("//a//h5[contains(text(),'Chennai')]");
	System.out.println(textHotelName3.getText());
	
	WebElement textHotelPrice1 = findLocatorByXpath("//div//strong[@class='total-prize']");
	System.out.println(textHotelPrice1.getText());
	
	Thread.sleep(2000);
	
	findLocatorByXpath("//a[text()='Cancel']").click();
			
	
	alertAccept();
	
	WebElement txtCancelBooking = findLocatorByXpath("//ul//li[@class='alertMsg']");
	System.out.println(txtCancelBooking.getText());
	
//	WebElement btnMyBooking3 = findLocatorById("step2");
//	elementClick(btnMyBooking3);
	
	WebElement textBookingId4 = findLocatorByXpath("//a//span[contains(text(),'#')]");
	String bookingId4 = elementGetText(textBookingId4);
	String replaceBookingId4 = bookingId4.replace("#", "");
	System.out.println(replaceBookingId4);
	
//	WebElement txtBookingNo3 = findLocatorByXpath("//input[@name='search']");
//	elementSendKeysEnter(txtBookingNo3, replaceBookingId4);
	
	WebElement textHotelName4 = findLocatorByXpath("//a//h5[contains(text(),'Chennai')]");
	System.out.println(textHotelName4.getText());
	
	WebElement textHotelPrice2 = findLocatorByXpath("//div//strong[@class='total-prize']");
	System.out.println(textHotelPrice2.getText());
	
	WebElement btnCancelled = findLocatorByXpath("//div//button[@class='cancle btn filter_btn mb-3']");
	System.out.println(btnCancelled.getText());
	
	
	}
	
	
	@AfterClass
	public static void afterClass() {
		
	closeBrowser();
		
	}
	
}
