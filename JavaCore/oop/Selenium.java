package oop;

public class Selenium {
	//Thuoc tinh	Property/Field/Variable
	private String name="Selenium API" ;
	
	//phuong thuc   Method/Function
	
	private String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name=name;
	}
	//default
	String organization="Selenium HQ";
	//default
	String getOrganization() {
		return this.organization;
	}
	
	//protected
	protected String sponsor="SauceLab";
	//protected
	protected String getSponsor() {
		return this.sponsor;
	}
	
	public String version="3.4.1";
	
	public static void main(String [] args) {
		Selenium selenium = new Selenium();
		System.out.println(selenium.getName());
		selenium.setName("SELENIUM API");
		System.out.println(selenium.getName());
		
	}

}

