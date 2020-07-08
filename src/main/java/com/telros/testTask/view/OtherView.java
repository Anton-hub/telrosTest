package com.telros.testTask.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.context.SecurityContextHolder;

@Route(OtherView.ROUTE)
@PageTitle("Other Page")
public class OtherView extends VerticalLayout {
    public static final String ROUTE = "other";
    public OtherView(){
        Button logout = new Button("Logout", event -> {
            SecurityContextHolder.clearContext();
            UI.getCurrent().getPage().reload();
        });
        Button back = new Button("Back", event -> UI.getCurrent().getPage().setLocation("login"));
        add(back, logout);
    }
}
