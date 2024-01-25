package commande;

import java.io.IOException;
import java.util.List;

import beans.Client;
import controleur.SimpleControleur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.ClientManager;

public class Editcustomer implements ICommand{

	String jspPage = "/WEB-INF/accueil/index.jsp";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientManager manager = ClientManager.getInstance();
		List<Client> customers = manager.getClients();
		// R?p?r l'id du client ?diter
        String id = request.getParameter("id");
        
        // R?p?r le bean client (objet m?er) correspondant ?'id
        Client customer = manager.getCustomer(id);
        
        // Positionner le bean client comme attribut de requ? 
        // Attribut utilis?ar la page jsp
        request.setAttribute("customer", customer);
        
        // Prochaine page JSP ?etourner au navigateur
        jspPage = "/WEB-INF/pagesclient/editerClientAvecJSTL.jsp"; 
		
		return jspPage;
	}
	
}
