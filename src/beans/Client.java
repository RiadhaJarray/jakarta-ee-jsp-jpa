package beans;

import java.io.Serializable;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/**
 * 
 * @author Pascal
 *
 */

// HttpSessionBindingListener
// un objet peut être notifié du fait qu'il a été ajouté à une session. 
// Il doit pour cela implémenter l'interface HttpSessionBindingListener. 
// Cette interface expose deux méthodes :
//		- valueBound(HttpSessionBindingEvent) : appelée lorsque l'objet est attaché à une session.
//		- valueUnbound(HttpSessionBindingEvent) : appelée lorsque l'objet est détachée de la session.
// Ces deux méthodes reçoivent en paramètre un objet de type HttpSessionBindingEvent. 
// Cet événement expose les deux méthodes classiques getName() et getValue(). 
// Il expose également getSession(), qui retourne la session à laquelle cet objet est attaché, 
// ou de laquelle il est détaché. 
public class Client implements Serializable, HttpSessionBindingListener{

	
	private static final long serialVersionUID = 6552720450742917972L;
	
	private String id;
    private String firstName;
    private String lastName;
    private String address;


    public Client () {
    }

    /**
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     */
    // Si un constructeur autre que le constructeur par défaut a été defini, il faut définir 
    // un constructeur par défaut (sans parametre)
    public Client(String id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    /**
     * 
     * @return	address	
     */
    public String getAddress()
    {
        return address;
    }
    /**
     * 
     * @param address
     */
    public void setAddress(String address)
    {
    	this.address = address;
    }

    public String getFirstName()
    {
        return firstName;
    }

    /**
     * 
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
    	this.firstName = firstName;
    }
    /**
     * 
     * @return	lastName	Prénom du client
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * 
     * @param lastName		Prénom du client
     */
    public void setLastName(String lastName)
    {
    	this.lastName = lastName;
    }

    /**
     * 
     * @return	id	Identifiant du client
     */
    public String getId()
    {
        return id;
    }

    /**
     * 
     * @param id	Identifiant du client
     */
    public void setId(String id)
    {
    	this.id = id;
    }
    
    // Méthode appelée lorsque l'objet est attaché à une session.
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut lié");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());		
	}

	// Méthode appelée lorsque l'objet est détachée de la session.
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("\nAttribut non lié");
		System.out.println(event.getSession().getId());
		System.out.println(event.getName() + "', '" + event.getValue());	
	}
	
	public String toString() {
		String str = firstName + " " + lastName;
		return str;
	}
}