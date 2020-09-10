package test;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generics.BaseTest;
import pom.ActitimeLoginPage;

@Listeners(generics.Screenshot.class)

public class TestActitimeLogin extends BaseTest
{

	@Test
	public void login() throws IOException
	{
		ActitimeLoginPage aa=new ActitimeLoginPage(driver);
		aa.loginMethod();
	}
}
