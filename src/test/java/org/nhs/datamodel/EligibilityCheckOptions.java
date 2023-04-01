package org.nhs.datamodel;

public class EligibilityCheckOptions {
	
	String livingCountry;
	
	String dob;
	boolean isdiabetic;
	boolean doLiveWithPartner;
	boolean hasClaimBenefits;
	boolean hasSavings;
	boolean pregnant;
	
	public boolean isPregnant() {
		return pregnant;
	}
	public void setPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}
	public String getLivingCountry() {
		return livingCountry;
	}
	public void setLivingCountry(String livingCountry) {
		this.livingCountry = livingCountry;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public boolean isIsdiabetic() {
		return isdiabetic;
	}
	public void setIsdiabetic(boolean isdiabetic) {
		this.isdiabetic = isdiabetic;
	}
	public boolean isDoLiveWithPartner() {
		return doLiveWithPartner;
	}
	public void setDoLiveWithPartner(boolean doLiveWithPartner) {
		this.doLiveWithPartner = doLiveWithPartner;
	}
	public boolean isHasClaimBenefits() {
		return hasClaimBenefits;
	}
	public void setHasClaimBenefits(boolean hasClaimBenefits) {
		this.hasClaimBenefits = hasClaimBenefits;
	}
	public boolean isHasSavings() {
		return hasSavings;
	}
	public void setHasSavings(boolean hasSavings) {
		this.hasSavings = hasSavings;
	}


}
