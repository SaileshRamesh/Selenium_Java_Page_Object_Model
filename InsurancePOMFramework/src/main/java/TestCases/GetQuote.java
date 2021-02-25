package TestCases;

import java.util.Hashtable;
import java.util.Scanner;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageClasses.CurrentInsurancePage;
import PageClasses.EnterInfoPage;
import PageClasses.GetCondoQuote;
import PageClasses.GetQuotePage;
import PageClasses.LandingPage;
import PageClasses.PersonaLInfoPage;
import PageClasses.PropertyInfoPage;
import PageClasses.SavingsPage;
import PageClasses.YourInfoPage;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import utilities.TestDataProvider;


public class GetQuote extends BaseTestClass {
	
	LandingPage landingpage;
	EnterInfoPage enterInfoPage;
	GetQuotePage getQuotePage;
	YourInfoPage yourInfoPage;
	PersonaLInfoPage personaLInfoPage;
	CurrentInsurancePage currentInsurancePage;
	PropertyInfoPage propertyInfoPage;
	SavingsPage savingsPage;
	GetCondoQuote getCondoQuote;
	
	/**********Second push*********/
	
	@Test(priority=1, dataProvider="getViewGetQuote")
	public void ViewGetQuote(Hashtable<String, String> dataTable){
		
		logger=report.createTest(dataTable.get("Comment"));
		/*System.out.println("Enter the number to choose the browser");
		System.out.println("1.Chrome\n2.Mozilla Firefox\n3.Internet Explorer");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int browser=sc.nextInt();
		invokeBrowser(browser);*/
		/**********************************/
	    PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingpage = pageBase.OpenApplication();
		waitLoad(4);
		landingpage.assertTitle(dataTable.get("PageTitle"));
	    landingpage.clickProperty();
	    waitLoad(3);
	    landingpage.ClickRenters();
	    landingpage.enterZip(dataTable.get("Zipcode"));
	    enterInfoPage = landingpage.clickGetMyPrice();
	    waitLoad(7);
	    enterInfoPage.assertTitle(dataTable.get("title2"));
	    enterInfoPage.enterFirstName(dataTable.get("FirstName"));
	    enterInfoPage.enterLastName(dataTable.get("LastName"));
	    enterInfoPage.enterEmail(dataTable.get("Email"));
	    enterInfoPage.enterStreet(dataTable.get("StreetAdd"));
	    enterInfoPage.enterAptNo(dataTable.get("AptNo"));
	    enterInfoPage.enterHowLongCB();
	    enterInfoPage.selectTypeBuilding(dataTable.get("TypeBuilding"));
	    scrollDown();
	    enterInfoPage.selectDOBMM(dataTable.get("Month"));
	    enterInfoPage.enterdate(dataTable.get("Date"));
	    enterInfoPage.enterYear(dataTable.get("Year"));
	    enterInfoPage.enterPhone(dataTable.get("Phone"));
	    enterInfoPage.clickCurrently();
	    enterInfoPage.selectStuff("$5,000");
	    getQuotePage=enterInfoPage.enterDetails();
	    waitLoad(10);
	    getQuotePage.ViewQuote("$6.42");
	}
	

	@Test(priority=2, dataProvider="getViewGetQuoteNull")
	public void verifyErrorMessagesNull(Hashtable<String, String> dataTable){
		logger=report.createTest(dataTable.get("Comment"));
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingpage = pageBase.OpenApplication();
		waitLoad(4);
		landingpage.clickProperty();
	    waitLoad(3);
	    landingpage.ClickRenters();
	    landingpage.enterZip(dataTable.get("Zipcode"));
	    enterInfoPage = landingpage.clickGetMyPrice();
	    waitLoad(7);
	    enterInfoPage.assertTitle(dataTable.get("title2"));
	    enterInfoPage.enterFirstName(dataTable.get("FirstName"));
	    enterInfoPage.enterLastName(dataTable.get("LastName"));
	    getQuotePage=enterInfoPage.enterDetails();
	    enterInfoPage.verifyEmailMessage(dataTable.get("msgMail"));
	    enterInfoPage.verifyStreetMail(dataTable.get("StreetAdd"));
	    enterInfoPage.verifyHowLong(dataTable.get("HowLong"));
	    enterInfoPage.verifyType(dataTable.get("TypeBuilding"));;
	    enterInfoPage.verifyDOB(dataTable.get("DOBerror"));;
	    enterInfoPage.verifyPhone(dataTable.get("PhoneError"));;
	    enterInfoPage.verifyCurrently(dataTable.get("CurrentlyError"));
	    enterInfoPage.verifyRoughly(dataTable.get("RoughlyError"));
	}
	
	
	@Test(priority=3, dataProvider="getViewGetQuoteNegative")
	public void verifyErrorMessagesInvalid(Hashtable<String, String> dataTable){
		logger=report.createTest(dataTable.get("Comment"));
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingpage = pageBase.OpenApplication();
		waitLoad(4);
		landingpage.assertTitle(dataTable.get("PageTitle"));
	    landingpage.clickProperty();
	    waitLoad(3);
	    landingpage.ClickRenters();
	    landingpage.enterZip("00000");
	    enterInfoPage = landingpage.clickGetMyPrice();
		landingpage.AssertError(dataTable.get("zipError"));          
		landingpage.refresh();
	    landingpage.clickProperty();
	    waitLoad(3);
	    landingpage.ClickRenters();
	    landingpage.enterZip(dataTable.get("Zipcode"));
	    enterInfoPage = landingpage.clickGetMyPrice();
	    waitLoad(7);
	    enterInfoPage.assertTitle(dataTable.get("title2"));
	    enterInfoPage.enterFirstName(dataTable.get("FirstName"));
	    enterInfoPage.enterLastName(dataTable.get("LastName"));
	    enterInfoPage.enterEmail(dataTable.get("Email"));
	    enterInfoPage.enterStreet(dataTable.get("StreetAdd"));
	    enterInfoPage.enterAptNo(dataTable.get("AptNo"));
	    enterInfoPage.enterHowLongCB();
	    enterInfoPage.selectTypeBuilding(dataTable.get("TypeBuilding"));
	    scrollDown();
	    enterInfoPage.selectDOBMM(dataTable.get("Month"));
	    enterInfoPage.enterdate(dataTable.get("Date"));
	    enterInfoPage.enterYear(dataTable.get("Year"));
	    enterInfoPage.enterPhone(dataTable.get("Phone"));
	    enterInfoPage.clickCurrently();
	    enterInfoPage.selectStuff("$5,000");
	    getQuotePage=enterInfoPage.enterDetails();
	    enterInfoPage.verifyInvalidEmail(dataTable.get("invalidEmail"));
	    enterInfoPage.verifyInvalidAddress(dataTable.get("invalidAddress"));
	    enterInfoPage.verifyInvalidDOB(dataTable.get("invalidDOB"));
	    enterInfoPage.verifyInvalidPhone(dataTable.get("invalidPhone"));
	}
	
	@Test(priority=4, dataProvider="getQuoteCondo")
	public void CondoViewQuote(Hashtable<String, String> dataTable){
		
		logger=report.createTest(dataTable.get("Comment"));
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingpage = pageBase.OpenApplication();
		waitLoad(4);
		landingpage.assertLinkText(dataTable.get("LinkText"));
	    landingpage.clickProperty();
	    waitLoad(3);
		landingpage.ClickCondo();
		landingpage.enterZip(dataTable.get("Zipcode"));
		yourInfoPage = landingpage.clickGetMyPrice1();
		waitLoad(5);
		yourInfoPage.assertText("Address You Want To Insure");
		yourInfoPage.enterStreetAdd(dataTable.get("StreetAdd"));
		yourInfoPage.enterAptUnit(dataTable.get("AptNo"));
		yourInfoPage.currentlyCheck();
		personaLInfoPage = yourInfoPage.nextBtnClick();
		personaLInfoPage.assertText(dataTable.get("Title3"));
		personaLInfoPage.enterFname(dataTable.get("Fname"));
		personaLInfoPage.enterLname(dataTable.get("Lname"));
		personaLInfoPage.selectDOBMM(dataTable.get("Month"));
		personaLInfoPage.enterdate(dataTable.get("Date"));
		personaLInfoPage.enterYear(dataTable.get("Year"));
		personaLInfoPage.enterPhone(dataTable.get("phone"));
		personaLInfoPage.enterEmail(dataTable.get("email"));
		currentInsurancePage = personaLInfoPage.saveAndContinue();
		currentInsurancePage.assertText(dataTable.get("title4"));
		currentInsurancePage.selectDoYou(dataTable.get("DoYou"));
		currentInsurancePage.policyCancellation();
		currentInsurancePage.autoPolicy();
		currentInsurancePage.claimLoss();
		propertyInfoPage = currentInsurancePage.saveAndContinue();
		propertyInfoPage.assertText(dataTable.get("title5"));
		propertyInfoPage.enteryearBuilt(dataTable.get("yearBuilt"));
		propertyInfoPage.selectUnitsBuilding("2");
		propertyInfoPage.selecthomeOccupany(dataTable.get("occu"));
		propertyInfoPage.clickHomeSharing();
		propertyInfoPage.clickReplacementCost();
		propertyInfoPage.clickDogIndicator();
		propertyInfoPage.selectmilesToFireStation(dataTable.get("Fire"));
		propertyInfoPage.clickfeetToFire();
		propertyInfoPage.selectoutsideWall(dataTable.get("Wall"));
		savingsPage = propertyInfoPage.click();
		savingsPage.assertText(dataTable.get("title6"));
		savingsPage.selecthighestEducation(dataTable.get("Education"));
		savingsPage.selectemploymentStatus("Employed");
		getCondoQuote = savingsPage.click();
		getCondoQuote.ViewQuote("16");
		
	}
	
	@DataProvider
	public Object[][] getViewGetQuote(){
		return TestDataProvider.getTestData("TestData.xlsx", "SampleData1", "TC_001");
	}
	
	@DataProvider
	public Object[][] getViewGetQuoteNull(){
		return TestDataProvider.getTestData("TestData.xlsx", "SampleData1", "TC_002");
	}
	
	@DataProvider
	public Object[][] getViewGetQuoteNegative(){
		return TestDataProvider.getTestData("TestData.xlsx", "SampleData1", "TC_003");
	}
	
	@DataProvider
	public Object[][] getQuoteCondo(){
		return TestDataProvider.getTestData("TestData.xlsx", "SampleData1", "TC_004");
	}


}
