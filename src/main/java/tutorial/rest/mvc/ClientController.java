package tutorial.rest.mvc;

/**
 * Created by nelson on 11/12/2014.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tutorial.core.models.entities.Client;
import tutorial.core.services.ClientService;
import tutorial.core.services.util.ClientList;
import tutorial.rest.exceptions.ConflictException;
import tutorial.rest.resources.ClientListResource;
import tutorial.rest.resources.ClientResource;
import tutorial.rest.resources.asm.ClientListResourceAsm;
import tutorial.rest.resources.asm.ClientResourceAsm;

import java.net.URI;

@Controller
@RequestMapping("/rest/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ClientListResource> findAllBlogs()
    {
        ClientList blogList = clientService.getClients();
        ClientListResource clientListResource = new ClientListResourceAsm().toResource(blogList);
        return new ResponseEntity<ClientListResource>(clientListResource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ClientResource> createClient(@RequestBody ClientResource clientResource){
        try {
            Client client = clientService.createClient(clientResource.toClient());
            ClientResource clientResource1 = new ClientResourceAsm().toResource(client);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(clientResource1.getLink("self").getHref()));
            return new ResponseEntity<ClientResource>(clientResource1,headers,HttpStatus.CREATED);

        }catch (Exception exception){
            throw new ConflictException(exception);
        }

    }

}
