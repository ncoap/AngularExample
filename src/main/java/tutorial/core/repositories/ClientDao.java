package tutorial.core.repositories;

import tutorial.core.models.entities.Client;

import java.util.List;

/**
 * Created by nelson on 11/12/2014.
 */
public interface ClientDao {

    public List<Client> getClients();
    public Client createClient(Client client);
}
