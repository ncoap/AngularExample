package tutorial.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.services.util.ClientList;
import tutorial.rest.mvc.ClientController;
import tutorial.rest.resources.ClientListResource;

/**
 * Created by nelson on 11/12/2014.
 */
public class ClientListResourceAsm extends ResourceAssemblerSupport<ClientList,ClientListResource> {

    public ClientListResourceAsm(){
        super(ClientController.class,ClientListResource.class);
    }


    @Override
    public ClientListResource toResource(ClientList clientList) {

        ClientListResource clientListResource = new ClientListResource();
        clientListResource.setClients(new ClientResourceAsm().toResources(clientList.getClients()));

        return clientListResource;
    }
}
