package com_nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowser {
    //1. Setup Multi Browser
    static String browser = "Chrome";
    //static String browser = "FireFox";
    //static String browser = "Edge";
    //Base Url
    static String baseUrl = "https://demo.nopcommerce.com/";
    // Launch the Browser
    static WebDriver driver;

    //Static method
    public static void multiBrowserTest() {
        //if- else loop
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
    }

    public static void main(String[] args) {
        //method calling
        multiBrowserTest();

        //2. Open Url
        driver.get(baseUrl);

        // 3.Print the title of the page
        System.out.println("Title of the page : " + driver.getTitle());

        // 4. Print the current url
        System.out.println("Current Url : " + driver.getCurrentUrl());

        //5. Print the page source
        System.out.println("Page source : " + driver.getPageSource());

        //6.Navigate to Url
        String navigateUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(navigateUrl);

        //7. Print the current url
        System.out.println("Get Current Url : " + driver.getCurrentUrl());

        //8.Navigate back to the home page
        driver.navigate().back();
        System.out.println("Back to the home page : " + driver.getCurrentUrl());

        //9.Navigate to the login page
        driver.navigate().forward();

        //10. Print the current Url
        System.out.println("Navigate to the login page : " + driver.getCurrentUrl());

        //11.Refresh the page
        driver.navigate().refresh();

        //12.Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("abc2023@gamil.com");

        //13.Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("abc@2023");

        //14.Click on Login Button
        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();

        //15.Close the Browser
        driver.quit();
    }
}//Run the programme