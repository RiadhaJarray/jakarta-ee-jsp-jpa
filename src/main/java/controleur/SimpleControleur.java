package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Client;
import commande.Addcustomer;
import commande.Addcustomerexe;
import commande.Createlist;
import commande.Displaycustomer;
import commande.Displaycustomer1;
import commande.Displaylist;
import commande.Displaylist1;
import commande.Editcustomer;
import commande.Editcustomer1;
import commande.Editcustomer2;
import commande.ICommand;
import commande.Supprimercustomer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import manager.ClientManager;

/**
 * 
 * @author Pascal
 *
 */
@SuppressWarnings("serial")
@WebServlet(name = "controleur",urlPatterns="/controleur")
public class SimpleControleur extends HttpServlet
{
	ClientManager manager = ClientManager.getInstance();

	List<Client> customers = manager.getClients();
	private Map<String, ICommand> commandMap = new HashMap<>();

	public SimpleControleur () {
		commandMap.put("displaylist", new Displaylist());
		commandMap.put("displaylist1", new Displaylist1());
		commandMap.put("createlist", new Createlist());
		commandMap.put("displaycustomer", new Displaycustomer());
		commandMap.put("addcustomer", new Addcustomer());
		commandMap.put("addcustomerexe", new Addcustomerexe());
		commandMap.put("displaycustomer1", new Displaycustomer1());
		commandMap.put("editcustomer", new Editcustomer());
		commandMap.put("editcustomer1", new Editcustomer1());
		commandMap.put("editcustomer2", new Editcustomer2());
		commandMap.put("supprimercustomer", new Supprimercustomer());
	}
    protected void doProcess(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    { 	 
    	
    	HttpSession m_session;
    	
    	// R?p?tion de la session
    	m_session = request.getSession(true);
    	// Dur?de la session = 1H
    	m_session.setMaxInactiveInterval(3600);
    	
    	// R?p?tion du contexte
    	//ServletContext context = this.getServletContext();
    	
    	// R?p?tion de l'action demand?
        String action = request.getParameter("action");
        
        // Par d?ut page d'accueil
        String jspPage = "/WEB-INF/accueil/index.jsp";

        ICommand command = commandMap.get(action);
        // SI aucune action définie dans la requête 
        // ALORS action=default
        if ((action.isEmpty())){
            action = "default";
        }

        if ("default".equals(action)){
        	// Prochaine page JSP ?etourner au navigateur
            jspPage = "/WEB-INF/accueil/index.jsp";
        }
        else {
        	jspPage = command.execute(request , response);
        	System.out.println("le nombre des clients :: "+ customers.size());
        }
        
/*
        // Demande d'affichage de la liste des clients avec JSTL
        else if ("displaylist".equals(action))
        {
        	// Si le manager a ? cr?
        	if (manager != null) {
        		// Récupérer la liste des clients g?e par le manager
        		customers = manager.getCustomers();
        		
                // Positionner la liste des clients comme attribut de requête  
                // Attribut utilis?ar la page jsp
        		request.setAttribute("customers", customers);
        		
        		// Prochaine page JSP ?etourner au navigateur
        		jspPage = "/WEB-INF/pagesclient/afficherListeClientsAvecJSTL.jsp"; 
        	}
        	else
        		// Prochaine page JSP ?etourner au navigateur
        		jspPage = "/WEB-INF/erreurs/afficherErreurListe.jsp";
        }
        // Demande d'affichage de la liste des clients sans JSTL
        else if ("displaylist1".equals(action))
        {
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
        }
        // Demande de cr?ion de la liste des clients
        else if ("createlist".equals(action))
        {
        	// Cr?ion du manager qui g? la liste des clients
            manager = new ClientManager();
            
            // G?rer la liste des clients
            customers = manager.createCustomers();
            
            // Positionner la liste des clients comme attribut de requ? 
            // Attribut utilis?ar la page jsp
            //request.setAttribute("customers", customers);

            // Prochaine page JSP ?etourner au navigateur
            jspPage = "/WEB-INF/accueil/index.jsp";
        }
        // Demande d'affichage des informations d'un client (Avec JSTL)
        else if ("displaycustomer".equals(action))
        {
        	// R?p?r l'id du client a afficher
            String id = request.getParameter("id");
            
            // R?p?r le bean client (objet m?er) correspondant ?'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ? 
            // Attribut utilis?ar la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP ?etourner au navigateur
            jspPage = "/WEB-INF/pagesclient/afficherClientAvecJSTL.jsp";
        }
        // Demande d'affichage des informations d'un client (Sans JSTL)
        else if ("displaycustomer1".equals(action))
        {
        	// R?p?r l'id du client a afficher
            String id = request.getParameter("id");
            
            // R?p?r le bean client (objet m?er) correspondant ?'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ? 
            // Attribut utilis?ar la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP ?etourner au navigateur
            jspPage = "/WEB-INF/pagesclient/afficherClientSansJSTL.jsp";
        }
        // Demande d'?tion des informations d'un client (avec JSTL)
        else if ("editcustomer".equals(action))
        {
        	// R?p?r l'id du client ?diter
            String id = request.getParameter("id");
            
            // R?p?r le bean client (objet m?er) correspondant ?'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ? 
            // Attribut utilis?ar la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP ?etourner au navigateur
            jspPage = "/WEB-INF/pagesclient/editerClientAvecJSTL.jsp";            
        }
        // Demande d'?tion des informations d'un client (sans JSTL)
        else if ("editcustomer1".equals(action))
        {
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
        }
        // Demande d'?tion des informations d'un client (sans JSTL et avec notation EL)
        else if ("editcustomer2".equals(action))
        {
        	// R?p?r l'id du client ?diter
            String id = request.getParameter("id");
            
            // R?p?r le bean client (objet m?er) correspondant ?'id
            Client customer = manager.getCustomer(id);
            
            // Positionner le bean client comme attribut de requ? 
            // Attribut utilis?ar la page jsp
            request.setAttribute("customer", customer);
            
            // Prochaine page JSP ?etourner au navigateur
            jspPage = "/WEB-INF/pagesclient/editerClientSansJSTLavecEL.jsp";  
        }
        else if ("addcustomer".equals(action))
        {
        	// Prochaine page JSP ?etourner au navigateur
            jspPage = "/WEB-INF/pagesclient/ajouterClientSansJSTL.jsp";
        }
        // Demande de modification des informations d'un client
        else if ("editcustomerexe".equals(action))
        {
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
        	

        	// R?p?r la liste des clients g?e par le manager
        	customers = manager.getCustomers();
        	
            // Positionner la liste des clients comme attribut de requ? 
            // Attribut utilis?ar la page jsp
        	request.setAttribute("customers", customers);
        	
        	// Prochaine page JSP ?etourner au navigateur
            jspPage = "/WEB-INF/pagesclient/afficherListeClientsSansJSTL.jsp";
        }
        // Demande d'ajout d'un client
        else if ("addcustomerexe".equals(action))
        {
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
        }
        //supprimer customer
        else if ("supprimercustomer".equals(action)) {
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
        }
 */
        // Envoyer la page correspondante ?a demande
        System.out.println("hello it's display ::  "+jspPage);
        dispatch(jspPage, request, response);
    }
    /**
     * 
     * @param jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void dispatch(String jsp, HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
    	// SI une page jsp a ? d?nie
        if (jsp != null)
            getServletContext().getRequestDispatcher(jsp).forward(request,response);
    }

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
    	doProcess(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
    	doProcess(request, response);
    }
}
