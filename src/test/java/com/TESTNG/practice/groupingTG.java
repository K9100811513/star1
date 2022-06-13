package com.TESTNG.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class groupingTG {
	@Test(groups="smokeGrp")
    public void smoke1( ) {
    	Reporter.log("smoke1",true);
    }
	@Test(groups="ftGrp")
    public void ft1( ) {
    	Reporter.log("ft1",true);
	}
	
	@Test(groups="ftGrp")
    public void ft2( ) {
    	Reporter.log("ft2",true);
	}
	@Test(groups="smokeGrp")
    public void smoke2( ) {
    	Reporter.log("smoke2",true);
    } 
	@Test(groups="itGrp")
    public void it1( ) {
    	Reporter.log("it1",true);
	}
	@Test(groups="itGrp")
    public void it2( ) {
    	Reporter.log("it2",true);
	}
	@Test(groups="smokeGrp")
    public void smoke3( ) {
    	Reporter.log("smoke3",true);
    }
	
	@Test(groups="smokeGrp")
    public void smoke4() {
    	Reporter.log("smoke4",true);
    }

	

}
