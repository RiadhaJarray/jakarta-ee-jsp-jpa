package commande;

import java.io.IOException;
import java.util.List;

import beans.Client;
import controleur.SimpleControleur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import manager.ClientManager;

public class Editcustomer1 implements ICommand{

	String jspPage = "/WEB-INF/accueil/index.jsp";
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientManager manager = ClientManager.getInstance();
		List<Client> customers = manager.getClients();
		
		HttpSession m_session;
		
		// R?p?tion de la session
		m_session = request.getSession(true);
		// Dur?de la session = 1H
		m_session.setMaxInactiveInterval(3600);
		
		// R?p?r l'id du client ?diter
        String id = request.getParameter("id");
        
        // R?p?r le bean client (objet m?er) correspondant ?'id
        Client customer = manager.getCustomer(id);
        
        // Positionner le bean client comme attribut de requ? 
        // Attribut utilis?ar la page jsp
        request.setAttribute("customer", customer);
        m_session.setAttribute("customer", customer);
        
        // Prochaine page JSP ?etourner au navigateur
        jspPage = "/WEB-INF/pagesclient/editerClientSansJSTL.jsp"; 
		
		return jspPage;
	}
	
}
