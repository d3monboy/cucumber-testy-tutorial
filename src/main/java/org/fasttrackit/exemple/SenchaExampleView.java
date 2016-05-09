package org.fasttrackit.exemple;

import com.sdl.selenium.web.WebLocator;



/**
 * Created by mihai on 5/9/2016.
 */
public class SenchaExampleView {
    public void open() {
        open("Grids", "Grid Data Binding");

    }

    public void open(String title, String exemple) {
        WebLocator gridTab = new WebLocator().setText(title);
        WebLocator gridDataBinding = new WebLocator().setText(exemple);
        // mouse over - because of scroll
        gridTab.mouseOver();
        gridTab.click();
        gridDataBinding.click();
    }

}
