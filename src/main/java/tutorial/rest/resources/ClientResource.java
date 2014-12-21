package tutorial.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import tutorial.core.models.entities.Client;

import java.util.Date;

/**
 * Created by nelson on 11/12/2014.
 */
public class ClientResource extends ResourceSupport {
    private String name;
    private String lastName;
    private Date registrationDate;
    private Date updateDate;
    private String address;
    private String urlAvatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public Client toClient(){

        Client client = new Client();
        client.setName(name);
        client.setLastName(lastName);
        client.setRegistrationDate(registrationDate);
        client.setUpdateDate(updateDate);
        client.setAddress(address);
        client.setUrlAvatar(urlAvatar);

        return client;
    }

}
