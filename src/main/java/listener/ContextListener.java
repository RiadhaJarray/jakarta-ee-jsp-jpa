package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public final class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("\nLabJSP_10-Servlet-JSP-BEAN-MVC : Contexte supprimé");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("\nLabJSP_10-Servlet-JSP-BEAN-MVC : Contexte initialisé");
		
	} 
}