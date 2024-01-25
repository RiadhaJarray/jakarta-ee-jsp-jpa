package commande;

import java.io.IOException;
import java.util.List;

import beans.Client;
import controleur.SimpleControleur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.ClientManager;

public class Createlist implements ICommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Cr?ion du manager qui g? la liste des clients
		ClientManager manager = ClientManager.getInstance();
		
        // G?rer la liste des clients
        List<Client> customers = manager.getClients();
        customers = manager.createCustomers();
        // Positionner la liste des clients comme attribut de requ? 
        // Attribut utilis?ar la page jsp
        //request.setAttribute("customers", customers);

        // Prochaine page JSP ?etourner au navigateur
        String jspPage = "/WEB-INF/accueil/index.jsp";
		
		return jspPage;
	}
	
}
