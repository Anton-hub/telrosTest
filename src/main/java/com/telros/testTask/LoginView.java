package com.telros.testTask;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Tag("sa-login-view")
@Route(LoginView.ROUTE)
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver  {
    public static final String ROUTE = "login";

    private LoginOverlay login = new LoginOverlay();

    public LoginView(){
        login.setAction("login");
        login.setOpened(true);
        login.setTitle("Auth Task");
        login.setDescription("Example user - user:password");
        getElement().appendChild(login.getElement());
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        login.setError(event.getLocation().getQueryParameters().getParameters().containsKey("error"));
    }
}
