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

public class Supprimercustomer implements ICommand{

	String jspPage = "/WEB-INF/accueil/index.jsp";
	
	
	@Override
	public String execute( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientManager manager = ClientManager.getInstance();
		List<Client> customers = manager.getClients();
		String id = request.getParameter("id");
    	//supprimer le customer
    	manager.deleteCustomer(id);
    	
    	// Récupéré la liste des clients géré par le manager
    	customers = manager.getCustomers();
    	
    	// Positionner la liste des clients comme attribut de requête 
        // Attribut utilisé la page jsp
    	request.setAttribute("customers", customers);
    	
    	// Prochaine page JSP ?etourner au navigateur
        jspPage = "/WEB-INF/pagesclient/afficherListeClientsSansJSTL.jsp";
		
		return jspPage;
	}
	
}
