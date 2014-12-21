package tutorial.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.core.models.entities.Client;
import tutorial.core.repositories.ClientDao;
import tutorial.core.services.ClientService;
import tutorial.core.services.util.ClientList;

import java.util.List;

/**
 * Created by nelson on 11/12/2014.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public ClientList getClients() {
        return new ClientList(clientDao.getClients());
    }

    @Override
    public Client createClient(Client client) {
        return clientDao.createClient(client);
    }
}
