package org.nhs.steps.action;

import org.junit.Assert;
import org.nhs.datamodel.EligibilityCheckOptions;
import org.nhs.pages.BirthDatePage;
import org.nhs.pages.BloodSugarCheckPage;
import org.nhs.pages.CareHomeCheckPage;
import org.nhs.pages.CheckForHelpStartPage;
import org.nhs.pages.ClaimBenefitsPage;
import org.nhs.pages.DentalPracticePage;
import org.nhs.pages.DiabetesCheckPage;
import org.nhs.pages.GPScoOrWalesPage;
import org.nhs.pages.LivingCountryPage;
import org.nhs.pages.LivingWithPartnerPage;
import org.nhs.pages.NhsHelpListPage;
import org.nhs.pages.PregnantInfoPage;
import org.nhs.pages.SavingsDetails;
import org.nhs.pages.WarPensionDetails;
import org.openqa.selenium.WebDriver;

public class GetHelpAction {
	EligibilityCheckOptions memberParticular;
	WebDriver driver;
	
	LivingCountryPage livingCtryPage;
	
	public GetHelpAction(WebDriver driver) {		
		this.driver = driver;
	}
	
	public GetHelpAction(EligibilityCheckOptions memberParticular, WebDriver driver) {
		this.memberParticular = memberParticular;
		this.driver = driver;
	}
	
	public void startCheckForHelp() {
		new CheckForHelpStartPage(driver).startCheck();	
		Assert.assertTrue(driver.getTitle().contains("Which country do you live in?"));
	}
	public void chooseLivingCountry(String country, WebDriver drivers) {
		livingCtryPage = new LivingCountryPage(driver);
		livingCtryPage.selectLivingCountryEng(country);		
 		
 		System.out.println("country:"+ country);
 		
	}
	
	
	public void verifyNavigationFromLivingCtry(String country) {
		switch (country) {
		//create country names as enums
		case "England":
		case "Wales":
			Assert.assertTrue(driver.getTitle().contains("Is your GP practice in Scotland or Wales?"));
			break;
		case "Scotland":
			Assert.assertTrue(driver.getTitle().contains("Do you live in the Highlands and Islands?"));
			break;
		case "NI":
			Assert.assertTrue(driver.getTitle().contains("You cannot use this service because you live in Northern Ireland"));
			break;
		case "":
			Assert.assertTrue(livingCtryPage.isErrMsgDisplayed());
		default:
			break;
		} 		
 		
	}
	
	
	
	public boolean chooseGPScoOrWal(String assertionStatement) {
		new GPScoOrWalesPage(driver).isGpScoOrWal(false);
 		Assert.assertTrue(driver.getTitle().contains("Which country is your dental practice in?"));
 		return false;
	}
	
	public boolean chooseDentalPrac(String country, String assertionStatement) {
		new DentalPracticePage(driver).selectDentalReg(country);
		Assert.assertTrue(driver.getTitle().contains("What is your date of birth?"));
		return false;
	}
	
	public void enterDateOfBirth(String assertionStatement) {
		if (new BirthDatePage(driver).enterDob(memberParticular.getDob())) {
			Assert.assertTrue(driver.getTitle().contains("Do you live with a partner?"));
		} else {
			Assert.fail("Check the date of birth given on the test");
		}		
		
	}
	
	public boolean chooseLiveWithPartner() {
		boolean doLiveWithPartner = memberParticular.isDoLiveWithPartner();
		new LivingWithPartnerPage(driver).doLiveWithPartner(doLiveWithPartner);
		if(doLiveWithPartner) {			
		} else {
			Assert.assertTrue(driver.getTitle().contains("Do you claim any benefits or tax credits?"));
		}
		
		return doLiveWithPartner;
	}
	
	public boolean chooseClaimBenefits() {
		boolean hasClaimBenefits = memberParticular.isHasClaimBenefits();
		new ClaimBenefitsPage(driver).provideClaimDetails(hasClaimBenefits);
		if(hasClaimBenefits) {
			//some more logic to be added
		} else {
			Assert.assertTrue(driver.getTitle().contains("Are you pregnant or have you given birth in the last 12 months?"));
		}
		
		return hasClaimBenefits;
	}

	public boolean checkIfPregnant() {
		boolean isPregnant = memberParticular.isPregnant();
		new PregnantInfoPage(driver).checkPregnantDetails(isPregnant);
		if(isPregnant) {
			//some more logic to be added
		} else {
			Assert.assertTrue(driver.getTitle().contains("Do you have an injury or illness caused by serving in the armed forces?"));
		}
		return isPregnant;
	}
	
	public boolean checkWarPension() {
		boolean hasSavings = memberParticular.isHasSavings();
		new WarPensionDetails(driver).checkWarPensionDetails(hasSavings);
		if(hasSavings) {
		} else {
			Assert.assertTrue(driver.getTitle().contains("Do you have diabetes?"));
		}
		
		return hasSavings;
	}
	
	public boolean checkIfDiabetic() {
		boolean isDiabetic = memberParticular.isIsdiabetic();
		new DiabetesCheckPage(driver).checkDiabeticDetails(isDiabetic);
		if(isDiabetic) {
			Assert.assertTrue(driver.getTitle().contains("Medication to control your diabetes?"));
		} else {
		}
		
		return isDiabetic;
	}
	
	public boolean checkBloodSugarLevel() {
		boolean stableSugarLevel = true;
		new BloodSugarCheckPage(driver).checkBloodSugarLevel(true);
		if(stableSugarLevel) {
			Assert.assertTrue(driver.getTitle().contains("Do you live permanently in a care home?"));
		} else {
		}
		
		return stableSugarLevel;
	}
	
	public boolean checkIfInCareHome() {
		boolean inCareHome = false;
		new CareHomeCheckPage(driver).whetherInCareHome(inCareHome);
		if(inCareHome) {
			System.out.println(driver.getTitle());
		} else {
			Assert.assertTrue(driver.getTitle().contains("Do you have more than £16,000 in savings"));
		}
		
		return inCareHome;
	}
	
	public boolean checkIfHaveSavings() {
		boolean hasSavings = false;
		new SavingsDetails(driver).doHaveSavings(hasSavings);
		if(hasSavings) {
		} else {
			Assert.assertTrue(driver.getTitle().contains("You get help with health costs"));
		}
		
		return hasSavings;
	}
	
	public void verifyNhsHelpList() {
		new NhsHelpListPage(driver);
		Assert.assertTrue(driver.getTitle().contains("You get help with health costs"));
	}
}
