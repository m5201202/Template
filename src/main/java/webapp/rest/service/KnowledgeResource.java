package webapp.rest.service;

import webapp.model.KnowledgeEntity;
import webapp.service.KnowledgeService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Path("/knowledge")
public class KnowledgeResource implements Serializable {
    @EJB
    private KnowledgeService knowledgeService;
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public RestKnowledge retrieveKnowledge(@PathParam("id") int id) {
        KnowledgeEntity knowledgeEntity = knowledgeService.findById((long) id);
        RestKnowledge restKnowledge = new RestKnowledge(knowledgeEntity);
        return restKnowledge;
    }

    @GET
    @Path("/all")
    @Produces({"application/json"})
    public List<RestKnowledge> retrieveAllKnowledge() {
        List<KnowledgeEntity> knowledgeEntityList = knowledgeService.findAll();
        List<RestKnowledge> restKnowledgeList = new ArrayList<>();
        for(KnowledgeEntity knowledgeEntity : knowledgeEntityList) {
            restKnowledgeList.add(new RestKnowledge(knowledgeEntity));
        }
        return restKnowledgeList;
    }
}