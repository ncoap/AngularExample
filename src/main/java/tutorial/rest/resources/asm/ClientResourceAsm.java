package tutorial.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.models.entities.Client;
import tutorial.rest.mvc.ClientController;
import tutorial.rest.resources.ClientResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
/**
 * Created by nelson on 11/12/2014.
 */
public class ClientResourceAsm extends ResourceAssemblerSupport<Client,ClientResource>{

    public ClientResourceAsm(){
        super(ClientController.class,ClientResource.class);
    }

    @Override
    public ClientResource toResource(Client client) {

        ClientResource clientResource = new ClientResource();
        clientResource.setName(client.getName());
        clientResource.setLastName(client.getLastName());
        clientResource.setRegistrationDate(client.getRegistrationDate());
        clientResource.setUpdateDate(client.getUpdateDate());
        clientResource.setAddress(client.getAddress());
        clientResource.setUrlAvatar(client.getUrlAvatar());
        clientResource.add(linkTo(ClientController.class).slash(client.getId()).withSelfRel());

        return clientResource;
    }
}
