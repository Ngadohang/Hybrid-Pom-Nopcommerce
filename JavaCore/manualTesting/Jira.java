package manualTesting;

import oop.Selenium;

public class Jira extends Selenium {

	public static void main(String[] args) {

	}

	String getParentSponsor() {
		return sponsor;
	}

	void setParentSponsor(String parentSponsor) {
		sponsor = parentSponsor;
		getSponsor();
	}
	
	String getVersion() {
		return version;
	}

}
