package commande;

import java.io.IOException;
import java.util.List;

import beans.Client;
import controleur.SimpleControleur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.ClientManager;

public class Displaylist1 implements ICommand{

	String jspPage = "/WEB-INF/accueil/index.jsp";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientManager manager = ClientManager.getInstance();
		List<Client> customers = manager.getClients();
		if (manager != null) {
    		// R?p?r la liste des clients g?e par le manager
    		customers = manager.getCustomers();
    		
            // Positionner la liste des clients comme attribut de requ? 
            // Attribut utilis?ar la page jsp
    		request.setAttribute("customers", customers);
    		
    		// Prochaine page JSP ?etourner au navigateur
    		jspPage = "/WEB-INF/pagesclient/afficherListeClientsSansJSTL.jsp";
    	}
    	else
    		// Prochaine page JSP ?etourner au navigateur
    		jspPage = "/WEB-INF/erreurs/afficherErreurListe.jsp";
		
		return jspPage;
	}
	
}
