package oop;

import basic.ParentClass;
import manualTesting.ChildClass;

public class Hey  {
	
	 public static final String DYNAMIC_LOCATOR= "//div[@class='%s']//a[text()='%s']";
	 
//	public String restParameter(String...B) {
//		return String.format(DYNAMIC_LOCATOR,(Object)B);
//	}
	public void getRestParameter(String locator,String e,String...values) {
		locator=String.format(locator,(Object[])values);
		System.out.println("click to element"+e+ locator);
	}
	public static void main(String[] args) {
		Hey hey=new Hey();
		hey.getRestParameter(DYNAMIC_LOCATOR,"huyen","cho","nga","hieu");

	}

}
