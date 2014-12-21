package tutorial.core.repositories.jpa;

import org.springframework.stereotype.Repository;
import tutorial.core.models.entities.Client;
import tutorial.core.repositories.ClientDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by nelson on 11/12/2014.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Client> getClients() {
        Query query = em.createQuery("SELECT c FROM Client c");
        return query.getResultList();
    }

    @Override
    public Client createClient(Client client) {
        em.persist(client);
        return client;
    }
}
