package commande;

import java.io.IOException;
import java.util.List;

import beans.Client;
import controleur.SimpleControleur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.ClientManager;

public class Addcustomerexe implements ICommand{

	
	String jspPage = "/WEB-INF/accueil/index.jsp";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientManager manager = ClientManager.getInstance();
		List<Client> customers = manager.getClients();
		
		System.out.println ("addcustomerexe");
    	// R?p?tion par la requ? des param?es saisis
    	String firstname = request.getParameter("firstName");
    	String lastname = request.getParameter("lastName");
    	String adresse = request.getParameter("address");  
    	String codePostal = request.getParameter("codePostal"); 
    	String ville = request.getParameter("ville"); 
    	
    	// Ajout du client ?a liste
    	manager.addCustomer(firstname, lastname, adresse, codePostal, ville);
    		
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
