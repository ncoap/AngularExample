package tutorial.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nelson on 11/12/2014.
 */
public class ClientListResource extends ResourceSupport {

    private List<ClientResource> clients = new ArrayList<ClientResource>();

    public List<ClientResource> getClients() {
        return clients;
    }

    public void setClients(List<ClientResource> clients) {
        this.clients = clients;
    }
}
