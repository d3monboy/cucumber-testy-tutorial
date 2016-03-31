package org.fasttrackit.exemple;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class LoginView {

    private TextField emailField = new TextField().setLabel("Email:");
    private WebLocator passField = new WebLocator().setName("password");
    private WebLocator loginBtn = new WebLocator().setClasses("login-btn");
    private WebLocator errormsg = new WebLocator("error-msg");

    public static void main(String[] args) {
        LoginView view = new LoginView();
        System.out.println(view.errormsg.getXPath());
    }

    public void enterEmail(String email) {
        System.out.println("enter email:" + email);
        emailField.sendKeys(email);
    }

    public void doLogin(String userName, String password) {
        enterEmail(userName);
        passField.sendKeys(password);
        loginBtn.click();
    }

    public void assertThatErrorIs(String message) {
        System.out.println(errormsg.getHtmlText());
        assertThat(errormsg.getHtmlText(), is(message));
    }
}
