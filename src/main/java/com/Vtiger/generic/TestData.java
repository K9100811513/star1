package com.Vtiger.generic;

import com.github.javafaker.Faker;

public class TestData {
	
	/**
	 * @author Kalpana
	 * this method will returns the emailaddress
	 * @return
	 */

public String getEmail()
{
	Faker fk=new Faker();
	 String email=fk.internet().emailAddress();
	 return email;
}

public String getFirstName() {
	Faker faker = new Faker();
	String firstname=faker.name().firstName();
	return firstname;
}
/**
 * @author Kalpana
 * This method will return name of the city
 * @return String city name
 */

public String getCityName() {
	Faker faker = new Faker();
	return	faker.address().cityName();
}

public String getLastName() {
	Faker faker = new Faker();
	String lastName=faker.name().lastName();
	return lastName;
}
/**
 * @author Kalpana
 *  This method will retuns the organisationname
 * @return Organisation name
 */


public String getOrgname() {
	Faker faker = new Faker();
	return	faker.company().industry();

}

}




