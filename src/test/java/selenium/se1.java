package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class se1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//to open a web application 
		
		driver.get("https://www.zomato.com");//to get the url
		
		//to capture the tittle of webpage
		String url=driver.getCurrentUrl();
	//	String s1= driver.getTitle();//to get the title of the webpage
		System.out.println(url);	driver.close();
		
		//Thread.sleep(3000);
		//to capture the url of current page
		driver.get("https//www.flipkart.com");
		String url1 =driver.getCurrentUrl();
		System.out.println(url1);
		driver.close();
		
		Thread.sleep(1000);
	
		 driver.get("www.flipkart.com");
		 
		 String fp =driver.getCurrentUrl();
		 System.out.println(fp);
		
		

	}

}
