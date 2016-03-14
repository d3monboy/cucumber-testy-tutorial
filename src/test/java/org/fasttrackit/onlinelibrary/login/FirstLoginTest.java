package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by mihai on 3/7/2016.
 */
public class FirstLoginTest extends TestBase {

    @Test
    protected void validLoginTest() {
        openLogInPage();
        doLogin("eu@fast.com", "eu.pass");

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("Could not login. Logout button not found.");
        }
    }

    @Test
    public void WhenEnterInvalidPasswordGetErrorMessage() {
        openLogInPage();
        doLogin("eu@fast.com", "wrong.pass");
        assertThaterrorIs("Invalid user or password!");
    }

    @Test
    public void WhenEnterOnlyEmailGetErrorMessage() {
        openLogInPage();
        doLogin("eu@fast.com", "");
        assertThaterrorIs("Please enter your password!");
    }


    @Test
    public void succesChangePassword(){
        openLogInPage();
        doLogin("eu@fast.com", "eu.pass");


        WebElement preferenceButton = driver.findElement(By.xpath("//nav//button"));
        preferenceButton.click();

        Utils.sleep(300);

        // css selector $$("#preferences-win input[name=password]")
        WebElement currentPassField = driver.findElement(By.xpath("//div[@id='preferences-win']//input[@name='password']"));
        currentPassField.sendKeys("eu.pass");

        WebElement newPassField = driver.findElement(By.xpath("//input[@name='newPassword']"));
        newPassField.sendKeys("eu.pass2");

        WebElement repeatPassField = driver.findElement(By.xpath("//input[@name='newPasswordRepeat']"));
        repeatPassField.sendKeys("eu.pass2");

        WebElement saveBtn = driver.findElement(By.cssSelector("#preferences-win button.btn-warning"));
        saveBtn.click();

        WebElement statusElement = driver.findElement(By.cssSelector("#preferences-win .status-msg"));
        System.out.println(statusElement.getText());
        assertThat(statusElement.getText(), is("Your password has been successfully changed."));
    }


    private void doLogin(String userName, String password) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(userName);

        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();
    }

    private void openLogInPage() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

    }

    private void assertThaterrorIs(String message) {
        WebElement errormsg = driver.findElement(By.className("error-msg"));
        System.out.println(errormsg.getText());
        assertThat(errormsg.getText(), is(message));
    }

}
