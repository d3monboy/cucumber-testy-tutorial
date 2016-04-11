package org.fasttrackit.forms;

import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.slf4j.LoggerFactory;
import org.testng.log4testng.Logger;

/**
 * Created by mihai on 3/28/2016.
 */
public class FirstFormView extends WebLocator {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FirstFormView.class);


    public FirstFormView() {
        System.out.println("you have created an FirstFormView");
        setTag("form");

        WebLocator legend = new WebLocator().setText("Form Title");
        setChildNodes(legend);

    }

    public DatePicker datePicker = new DatePicker();
    private WebLocator selectCalendar = new WebLocator(this).setClasses("icon-calendar");

//mai jos container checkbox!
    //private WebLocator stopProcessContainer = new WebLocator(this).setElPath("/div[3]");
    //private WebLocator enterContainer = new WebLocator(this).setElPath("/div[4]");


    public WebLocator stopProcesslabel = new WebLocator(this).setTag("label").setText("Stop the process?", SearchType.TRIM);
    public WebLocator enterLabel = new WebLocator(this).setTag("label").setText("label with Enter.",SearchType.CHILD_NODE);
    public CheckBox stopProcessCheckbox = new CheckBox(this).setLabel("Stop the process?", SearchType.TRIM).setLabelPosition("//");
    public CheckBox enterCheckbox = new CheckBox(enterLabel);



    public static void main(String[] args) {
        LOGGER.info("eu astazi mananc {} {}, ");
        //FirstFormView formView = new FirstFormView();


        //System.out.println(formView.stopProcesslabel.getSelector());


    }

    public static void generateTDXpath(){

        WebLocator emailCell = new WebLocator().setText("peterparker@mail.com");
        WebLocator row = new WebLocator().setTag("tr").setChildNodes(emailCell);
        CheckBox select = new CheckBox(row);

        LOGGER.debug(row.getXPath());


        Table table = new Table();
        Row row1 = table.getRow(new Cell(4, "peterparker@mail.com"));
        CheckBox select1 = new CheckBox(row1);

        LOGGER.debug(row1.getXPath());

    }

    public static void moreClassesExample(){
        WebLocator nav = new WebLocator().setClasses("Navbar navbar-default");
        WebLocator pref = new WebLocator(nav).setText("Preferences");
        System.out.println(nav.getSelector());
        System.out.println(pref.getSelector());

    }
}
