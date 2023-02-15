package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hamcrest.DiagnosingMatcher;
import org.hibernate.internal.build.AllowSysOut;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.model.Product;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

@Controller
public class seleniumController {
	
	@RequestMapping("/tree")
	public String show() {
		return "selenium";
	}

	@RequestMapping(path = "/two", method = RequestMethod.GET)
	public String hndl( HttpServletRequest request) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\Drivers\\d\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();

	     	String s = request.getParameter("sites");
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        String title, date, time, description, attending_person,register;
	    	System.out.println(s);	

    	//Boundry
    	
         if(s.equals("boundary"))
         {
             driver.get("https://boundarysys.com/webinars");
             
             List<WebElement> BoundryList = driver.findElements(By.xpath("//td[@class='upcoming-webinars-title']"));
             int size = BoundryList.size();

             js.executeScript("window.scrollBy(0,150)", "");
             if(size>0)
             for (WebElement eachEvent : BoundryList) {

//            	 title = eachEvent.getText();
//            	 date = eachEvent.findElement(By.xpath("//following-sibling::td[@class='upcoming-webinars-date']")).getText();
//            	 time = eachEvent.findElement(By.xpath("//following-sibling::td[@class='upcoming-webinars-time']")).getText();
//            	 register = eachEvent.findElement(By.xpath("//following-sibling::td[@class='upcoming-webinars-register']//a")).getAttribute("href");
//            	 
            	 System.out.println("Title  "+eachEvent.getText());
            	 System.out.println("Date   "+eachEvent.findElement(By.xpath("//following-sibling::td[@class='upcoming-webinars-date']")));
            	 
            	// System.out.println("Time   "+eachEvent.findElement(By.xpath("//following-sibling::td[@class='upcoming-webinars-time']")).getText());
            	// System.out.println("Register  "+eachEvent.findElement(By.xpath("//following-sibling::td[@class='upcoming-webinars-register']//a")).getAttribute("href"));
            	 
            	 //eachEvent.findElement(By.xpath("//following-sibling::td[@class='upcoming-webinars-register']//a")).click();
            	 
             }
             driver.quit();
         }
         
         if(s.equals("inneo")) {
             driver.get("https://www.inneo.co.uk/en/news/events.html");
             
             List<WebElement> inneoList = driver.findElements(By.xpath("//div[@id='filterItems']"));
             int size = inneoList.size();

             js.executeScript("window.scrollBy(0,150)", "");
             
             if(size > 0)
             {
            	 for(WebElement eachEvent : inneoList)
            	 {
            		 eachEvent.findElement(By.xpath("//span[@class='float_right']")).click();
            		  title = driver.findElement(By.xpath("//*[@id=\"eventdetails\"]/div[2]/div/div/h3")).getText();

                      date = driver.findElement(By.xpath("//*[@id=\"event-date\"]")).getText();

                      time = driver.findElement(By.xpath("//*[@id=\"eventdetails\"]/div[2]/div/div/div[3]/h2[3]")).getText();

                      description = driver.findElement(By.xpath("//*[@id=\"eventdetails\"]/div[2]/div/div/div[2]/p")).getText();

                      register = driver.findElement(By.xpath("//*[@id=\"eventdetails\"]/div[2]/div/div/span[2]/a")).getAttribute("href");

                      driver.findElement(By.xpath("//*[@id=\"eventdetails\"]/div[2]/div/div/a")).click();
            		 
            		 
            	 }
            	driver.quit();
             }
         }
         if(s.equals("concurrent")) {
             driver.get("https://www.concurrent-engineering.co.uk/webinars");
             
             Thread.sleep(2000);
             driver.findElement(By.xpath("//a[@id='hs-eu-confirmation-button']")).click();
             js.executeScript("window.scrollBy(0,400)", "");

             List<WebElement> concurrentList = driver.findElements(By.xpath("//div[@class='case_studies']//a"));
             int size = concurrentList.size();

             
             if(size > 0)
             {
            	 for(WebElement eachEvent : concurrentList)
            	 {
            		 driver.findElement(By.cssSelector("div.case__readmore > a")).click();

            		 register = eachEvent.getAttribute("href");
            		 Thread.sleep(3000);
            		  title = driver.findElement(By.xpath("//h1")).getText();

                      date = driver.findElement(By.xpath("//div[@class='event__container']//h2]")).getText();

                      time = driver.findElement(By.xpath("//div[@class='event__container']//h2")).getText();

                      description = driver.findElement(By.xpath("//*[@id=\"hs_cos_wrapper_widget_1584002834041\"]/section/div/div[1]/p/text()[1]")).getText();
            		 System.out.println(description);
            		 
            	 }
            	driver.quit();
             }
         }
         if(s.equals("tristar")) {
             driver.get("https://www.tristar.com/events");
             
             Thread.sleep(2000);
             js.executeScript("window.scrollBy(0,250)", "");

             List<WebElement> tristarList = driver.findElements(By.xpath("//div[@class='tribe-common-g-row tribe-events-calendar-list__event-row']//div[@class='tribe-events-calendar-list__event-details tribe-common-g-col']//a"));
             int size = tristarList.size();

             
             if(size > 0)
             {
            	 for(WebElement eachEvent : tristarList)
            	 {

            		 title = eachEvent.getText();
            		 System.out.println(title);
            		 register = eachEvent.getAttribute("href");
            		 System.out.println(register);
            		// date = eachEvent.findElements(By.xpath("//time[@class='tribe-events-calendar-list__event-datetime']")).getText();
                     time = eachEvent.findElement(By.xpath("//time[@class='tribe-events-calendar-list__event-datetime']")).getText();
                     System.out.println(time);
                     System.out.println(eachEvent);
            		 js.executeScript("window.scrollBy(0,50)", "");
                     
            	 }
            	driver.quit();
             }
         }
         if(s.equals("pdvision")) {
             driver.get("https://boundarysys.com/webinars/");
             
             Thread.sleep(2000);
             js.executeScript("window.scrollBy(0,250)", "");

             List<WebElement> tristarList = driver.findElements(By.xpath("//div[@class='tribe-common-g-row tribe-events-calendar-list__event-row']//div[@class='tribe-events-calendar-list__event-details tribe-common-g-col']//a"));
             int size = tristarList.size();

             
             if(size > 0)
             {
            	 for(WebElement eachEvent : tristarList)
            	 {

            		 title = eachEvent.getText();
            		 System.out.println(title);
            		 register = eachEvent.getAttribute("href");
            		 System.out.println(register);
            		// date = eachEvent.findElements(By.xpath("//time[@class='tribe-events-calendar-list__event-datetime']")).getText();
                     time = eachEvent.findElement(By.xpath("//time[@class='tribe-events-calendar-list__event-datetime']")).getText();
                     System.out.println(time);
                     System.out.println(eachEvent);
            		 js.executeScript("window.scrollBy(0,50)", "");
                     
            	 }
            	driver.quit();
             }
         }


	return "selenium";
	}

}