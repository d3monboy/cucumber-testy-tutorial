package org.fasttrackit.forms;

import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;

/**
 * Created by mihai on 3/28/2016.
 */
public class FirstFormView extends WebLocator {


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
    public CheckBox stopProcessCheckbox = new CheckBox(stopProcesslabel);
    public CheckBox enterCheckbox = new CheckBox(enterLabel);



    public static void main(String[] args) {
        FirstFormView formView = new FirstFormView();


        System.out.println(formView.stopProcesslabel.getSelector());
    }
}
