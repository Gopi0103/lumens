package com.lumens.selenium.tests;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginPage 
{
	public static void main(String[] args) throws BiffException, IOException, InterruptedException 
	{
				//Read the datas from the Excel sheet
				File f=new File("D:\\data\\Book2.xls");
				Workbook wb=Workbook.getWorkbook(f);
				Sheet sh=wb.getSheet("Sheet1");
				int rows=sh.getRows();
				int cols=sh.getColumns();
		
				//Store the input values
				String username=sh.getCell(0,0).getContents();
				String password=sh.getCell(0,1).getContents();
				
				//validate the inputs
				System.out.println(username);
				System.out.println(password);
				
				//Launch the browser
				System.setProperty("Webdriver.chrome.driver","C:\\chromedriver.exe");
				WebDriver d=new ChromeDriver();
				d.get("https://www.lumens.com/");
				d.manage().window().maximize();
				
				//Close the pop up window
				d.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);         
				d.findElement(By.xpath("//*[@id=\"ltkpopup-close-button\"]/a")).click();
				
				//Click Account and My Account dropdown
				d.findElement(By.className("text")).click();
				d.findElement(By.xpath("//a[@id='my_account_hdr_link']")).click();
				
				//Login
				d.findElement(By.xpath("//input[@id='dwfrm_login_username']")).sendKeys(username);
				d.findElement(By.xpath("//input[@id='dwfrm_login_password']")).sendKeys(password);
				d.findElement(By.xpath("//button[@name='dwfrm_login_login']")).click();
				
				//close the browser
				d.quit();
	}

}
