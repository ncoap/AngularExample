package tutorial.core.services.util;

import tutorial.core.models.entities.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nelson on 11/12/2014.
 */
public class ClientList {

    private List<Client> clients = new ArrayList<Client>();

    public ClientList(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
