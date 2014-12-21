package tutorial.core.services;

import tutorial.core.models.entities.Client;
import tutorial.core.services.util.ClientList;

import java.util.List;

/**
 * Created by nelson on 11/12/2014.
 */
public interface ClientService {

    public ClientList getClients();
    public Client createClient(Client client);
}
