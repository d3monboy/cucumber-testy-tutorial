package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.link.WebLink;
import org.fasttrackit.exemple.LoginView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FirstLoginTest extends TestBase {

    private LoginView loginPage = new LoginView();


    @Test
    public void whenEnterValidCredentialsImSuccessfullyLogin() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");


        WebLink logoutBtn = new WebLink().setText("Logout");
        logoutBtn.assertClick();
    }


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

    @DataProvider
    public static Object[][] invalidLogin() {
        return new Object[][]{
                {"eu@fast.com", "wrong.pass", "Invalid user or password!", true},
                {"eu@fast.com", "", "Please enter your password!", false},
                {"", "some.pass", "Please enter your email!", false},
                {"", "", "Please enter your email!", false}
        };

    }


    @Test(dataProvider = "invalidLogin")
    public void invalidLoginTest(String email, String pass, String errorMsg, boolean hasCredentials) {
        System.out.println("invalid login test:" + email + " - " + pass + " - " + errorMsg);
        openLoginPage();
        loginPage.doLogin("", "");
        loginPage.assertThatErrorIs("Please enter your email!");
        loginPage.doLogin(email, pass);
        loginPage.assertThatErrorIs(errorMsg);

    }


    private void openLoginPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        //        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
    }
}
