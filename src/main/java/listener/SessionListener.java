package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public final class SessionListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut ajouté");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());		
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut supprimé");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut modifié");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());
    }  
}