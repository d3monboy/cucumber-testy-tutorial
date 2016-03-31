package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.link.WebLink;

import org.fasttrackit.exemple.LoginView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;


public class FirstLoginTest extends TestBase {

    private LoginView loginPage  = new LoginView();


    @Test
    public void whenEnterValidCredentialsImSuccessfullyLogin() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");


        WebLink logoutBtn = new WebLink().setText("Logout");
        logoutBtn.assertClick();
    }


    @Test
    public void whenEnterInvalidPasswordIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "wrong.pass");
        loginPage.assertThatErrorIs("Invalid user or password!");
    }


    @Test
    public void whenEnterOnlyEmailIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "");
        loginPage.assertThatErrorIs("Please enter your password!");
    }


    @Test
    public void whenEnterOnlyPassowrdIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("", "some.pass");
        loginPage.assertThatErrorIs("Please enter your email!");
    }


    @Test
    public void whenNoCretentialsIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("", "");
        loginPage.assertThatErrorIs("Please enter your email!");
    }


    private void openLoginPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        //        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
    }
}
