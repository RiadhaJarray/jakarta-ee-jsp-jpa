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

public class Editcustomerexe implements ICommand{

	String jspPage = "/WEB-INF/accueil/index.jsp";
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientManager manager = ClientManager.getInstance();
		List<Client> customers = manager.getClients();
		// R?p?r les donn? du formulaire
    	int id = Integer.parseInt(request.getParameter("id"));
    	String firstname = request.getParameter("firstname");
    	String lastname = request.getParameter("lastname");
    	String adresse = request.getParameter("address");
    	String codePostal = request.getParameter("codePostal"); 
    	String ville = request.getParameter("ville"); 
    	
      	// Ajouter le nouveau client ?a liste des clients g?e par le
    	// manager
    	manager.setCustomer(id, firstname, lastname, adresse, codePostal, ville);
    	
    	/* En passant les paramètres au manager par l'intermédiaire d'un bean
    	Client mycust = new Client();
    	mycust.setId(request.getParameter("id"));
    	mycust.setFirstName(firstname);
    	mycust.setLastName(lastname);
    	mycust.setAddress(adresse);
    	manager.setCustomer(mycust); 
    	*/

    	// R?p?r la liste des clients g?e par le manager
    	customers = manager.getCustomers();
    	
        // Positionner la liste des clients comme attribut de requ? 
        // Attribut utilis?ar la page jsp
    	request.setAttribute("customers", customers);
    	
    	// Prochaine page JSP ?etourner au navigateur
        jspPage = "/WEB-INF/pagesclient/afficherListeClientsSansJSTL.jsp";
		
		return jspPage;
	}
	
}
