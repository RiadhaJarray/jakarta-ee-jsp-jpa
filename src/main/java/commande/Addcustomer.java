package commande;

import java.io.IOException;
import java.util.List;

import beans.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.ClientManager;

public class Addcustomer implements ICommand{
	String jspPage = "/WEB-INF/accueil/index.jsp";
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Prochaine page JSP ?etourner au navigateur
        jspPage = "/WEB-INF/pagesclient/ajouterClientSansJSTL.jsp";
		
		return jspPage;
	}
	
}
