package oop;

public class Katalon {

	public static void main(String[] args) {

		Selenium selenium = new Selenium();
		
		selenium.getOrganization();
		System.out.println(selenium.getOrganization());
		System.out.println(selenium.organization);
		
		// set bien default
		selenium.organization = "HQ";
		System.out.println(selenium.getOrganization());
		
		// set bien protected
		//selenium.sponsor="BrowserStack";
		System.out.println(selenium.getSponsor());

	}

}
