package com.telros.testTask;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(OtherView.ROUTE)
@PageTitle("OtherPage")
public class OtherView extends VerticalLayout {
    public static final String ROUTE = "other";
    public OtherView(){
        Image image = new Image("https://getupmag.ru/wp-content/uploads/2019/02/1477647840195420605.jpg", "All");
        add(image);
    }
}
