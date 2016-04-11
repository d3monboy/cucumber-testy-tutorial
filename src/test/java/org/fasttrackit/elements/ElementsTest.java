package org.fasttrackit.elements;


import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.exemple.DropDownList;
import org.fasttrackit.exemple.MultiSelectDropDownList;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.Keys;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ElementsTest extends TestBase {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ElementsTest.class);


    @Test
    public void checkboxTest() {
        openPage();


        FirstFormView form = new FirstFormView();
        form.enterCheckbox.assertClick();
        form.stopProcessCheckbox.assertClick();
        Utils.sleep(3000);
        form.stopProcesslabel.assertClick();
        form.enterLabel.assertClick();
    }

    @Test
    public void selectTest() {
        openPage();
        SelectPicker picker = new SelectPicker().setLabel("Tech:");


        String v = picker.getValue();
        Assert.assertEquals(v, "Auto");

        picker.select("Manual");

        v = picker.getValue();
        Assert.assertEquals(v, "Manual");
    }

    @Test

    public void dropDownTest() {
        openPage();
        DropDownList downList = new DropDownList().setLabel("Tech:");
        downList.select("Manual");

        DropDownList executeDownList = new DropDownList().setLabel("Execute");
        executeDownList.select("No");

        MultiSelectDropDownList sourceDownList = new MultiSelectDropDownList().setLabel("Source");
        sourceDownList.multiSelect("Tomatoes", "Mushrooms");


    }

    private Form form = new Form("Form Title");
    private UploadFile uploadBtn = new UploadFile(form, "TPT Test");
    //private WebLocator inputUpload = new WebLocator(uploadBtn).setTag("input");

    @Test
    public void uploadTest() {
        openPage();
        String resourcesPath = PropertiesReader.RESOURCES_DIRECTORY_PATH;
        System.out.println(resourcesPath);
        //uploadBtn.click();
        uploadBtn.upload(resourcesPath + "\\feature\\login\\login.feature");

    }

    private void openPage() {
        System.out.println("open login page");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html");
        //        driver.get("file:///C:/Producs/Testy/src/test/functional/app-demo/login.html");
    }

    @Test
    public void gmail(){
        driver.get("https://gmail.com");
        TextField emailField = new TextField().setPlaceholder("Enter your email");
        emailField.setValue("testy@examples.com");

        emailField.sendKeys(Keys.ENTER);
        //emailField.sendKeys(Keys.CONTROL, "a");
        //emailField.sendKeys(Keys.CONTROL, Keys.ARROW_LEFT, Keys.ARROW_LEFT);

        WebLocator errorEelement = new WebLocator().setText("Sorry, Google doesn't recognize that email. ");
        errorEelement.assertExists();

        //LOGGER.debug(error.getText());
       // LOGGER.debug(error.getXPath());

    }
}
