package com.telros.testTask.view;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.context.SecurityContextHolder;

@Tag("sa-login-view")
@Route(LoginView.ROUTE)
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver  {
    public static final String ROUTE = "login";

    private LoginOverlay login = new LoginOverlay();

    public LoginView(){
        LoginI18n loginForm = LoginI18n.createDefault();
        loginForm.getForm().setForgotPassword("Go to other Page");
        login.setForgotPasswordButtonVisible(true);
        login.addForgotPasswordListener(event -> {
            //login.close();
            UI.getCurrent().navigate("other");
        });
        login.setI18n(loginForm);
        login.setAction("login");
        login.setOpened(true);
        login.setTitle("Auth Task");
        login.setDescription("Example user - user:password");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        login.setError(event.getLocation().getQueryParameters().getParameters().containsKey("error"));
    }
}
