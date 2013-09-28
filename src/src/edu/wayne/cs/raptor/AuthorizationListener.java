package edu.wayne.cs.raptor;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 @author Evan
 Checks if session credentials are okay. If not, direct to login page.
 */
public class AuthorizationListener implements PhaseListener {

    public void afterPhase(PhaseEvent event) {

        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();
        boolean isLoginPage;
         if(currentPage != null)
             isLoginPage = (currentPage.lastIndexOf("index.xhtml") > -1);
        else
            isLoginPage = false;
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        if(session==null){
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "index.xhtml");
        }

        else{
            Object currentUser = session.getAttribute("username");

            if (!isLoginPage && (currentUser == null || currentUser == "")) {
                NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                nh.handleNavigation(facesContext, null, "index.xhtml");
            }
        }
    }

    public void beforePhase(PhaseEvent event) {

    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}