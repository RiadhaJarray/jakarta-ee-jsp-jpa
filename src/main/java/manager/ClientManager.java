package manager;

import java.util.ArrayList;
import java.util.List;
import beans.Client;

public class ClientManager
{	
	// Static instance of ClientManager
    private static ClientManager instance;

    // List of clients
    private static List<Client> rv;

    // Private constructor to prevent external instantiation
    private ClientManager() {
        // Initialize the list of clients
    	rv = (List<Client>)new ArrayList<Client>(30);
    }

    // Static method to get the singleton instance
    public static ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager();
        }
        return instance;
    }

    // Method to add a client to the list
    public void addClient(Client client) {
    	rv.add(client);
    }

    // Method to get the list of clients
    public List<Client> getClients() {
        return rv;
    }
	// Collection de clients
	//private List<Client> rv = (List<Client>)new ArrayList<Client>(30);
	
	// Nombre de clients créés lors de la génération de la liste
	private static final int NBCLIENTS = 10;
	
	public List<Client> createCustomers()
	{
	    return generateCustomers();
	}
	/**
	 * 
	 * @return liste des clients
	 */
    public List<Client> getCustomers()
    {
        return rv;
    }

    private List<Client> generateCustomers()
    {
        for (int i = 0; i < NBCLIENTS; i++) {
            //rv.add(getCustomerForCreate(String.valueOf(i)));
        	addClient(getCustomerForCreate(String.valueOf(i)));
        }
        return rv;
    }

    public Client getCustomerForCreate(String id)
    {
        return new Client(id, "Bob " + id, "Marley " + id, "123 rue de la Jamaique", "3130"+ id, "toulouse");
    }
    
    public Client getCustomer(String id)
    {
    	Client id1 = (Client)rv.get(Integer.parseInt(id));
        return id1;
    }
    
    public void setCustomer(int id, String firstname, String lastname, 
    		String address, String codePostal, String ville)
    {
    	Client id1 = (Client)rv.get(id);
    	id1.setFirstName(firstname);
    	id1.setLastName(lastname);
    	id1.setAddress(address);
    	id1.setCodePostal(codePostal);
    	id1.setVille(ville);
    }
    
    public void setCustomer(Client mycli)
    {
    	if (mycli != null)
    	{
	    	int id = Integer.parseInt(mycli.getId());
	    	Client hclient = (Client)rv.get(id);
	    	hclient.setFirstName(mycli.getFirstName());
	    	hclient.setLastName(mycli.getLastName());
	    	hclient.setAddress(mycli.getAddress());
	    	hclient.setCodePostal(mycli.getCodePostal());
	    	hclient.setVille(mycli.getVille());
	    	System.out.print("debug : setCustomer  " + mycli.getFirstName());
    	}
    }
    
    public void addCustomer(String firstname, String lastname, String address, String codePostal, String ville)
    {
    	System.out.println ("addCustomer()");
    	
    	int id=0;
    	for(Client current : rv) // pour chaque String current dans a
    	{
    	  System.out.println(current);
    	  if (Integer.parseInt(current.getId()) > id)
    	  	id = Integer.parseInt(current.getId());
    	}
    	id = id+1;
    	String sid = String.valueOf(id);
    	
    	Client id1 = new Client();	
    	id1.setId(sid);
    	id1.setFirstName(firstname);
    	id1.setLastName(lastname);
    	id1.setAddress(address);
    	id1.setCodePostal(codePostal);
    	id1.setVille(ville);

    	rv.add(id1);
    }
	public List<Client> getRv() {
		return rv;
	}
	public void setRv(List<Client> rv) {
		this.rv = rv;
	}
	public void deleteCustomer(String id) {
		rv.remove(getCustomer(id));
	}
}
