package webapp.rest.client;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class KnowledgeClient implements Serializable {
    public static void main(String args[]) { }
    public List<RestKnowledge> callRetrieveAllKnowledge() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/Template/webresources/knowledge/all");
        List<RestKnowledge> restKnowledgeList = webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<List<RestKnowledge>>() { });
        client.close();
        return restKnowledgeList;
    }
}