package com.ActitimeTestscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.Generic.Librariy.Baseclass;
import com.Actitime.Generic.Librariy.FileLibrary;
import com.Actitime.Generic.Librariy.ListenersImplementation;
import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;

@Listeners(ListenersImplementation.class)
public class CreateCustomer extends Baseclass {
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.getTasklink().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewBtn().click();
		tp.getNewCust().click();
		FileLibrary f=new FileLibrary();
		Thread.sleep(2000);
		String customername = f.readDataFromExcel("Sheet1", 3, 1);
		Thread.sleep(2000);
		tp.getCustname().sendKeys(customername);
		Thread.sleep(2000);
		String customerdesp = f.readDataFromExcel("Sheet1", 3, 2);
		Thread.sleep(2000);
		Assert.fail();
		tp.getCustdesp().sendKeys(customerdesp);
		tp.getCreatebtn().click();
		
	}


}
