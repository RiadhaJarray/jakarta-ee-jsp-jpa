package commande;

import java.io.IOException;
import java.util.List;

import beans.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.ClientManager;

/**
 * Les objet commande héritent de l'interface ICommand, qui est une classe avec 
 * une méthode execute() qui n'est pas codée. 
 * Pour chaque traitement que l'on veut effectuer, on va créer un objet commande
 * héritant de ICommand, dont on ira surcharger la méthode execute().
 * 
 * @author pascal & bob
 *
 */
public interface ICommand {
	// Méthode abstraite
	public String execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;
}
