package webapp.bean;

import webapp.model.KnowledgeEntity;
import webapp.service.KnowledgeService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class KnowledgeEditBean implements Serializable{
    @EJB
    private KnowledgeService knowledgeService;
    private long id;
    private KnowledgeEntity knowledge;
    public void init(){
        knowledge = knowledgeService.findById(id);
        return;
    }
    public String edit(){
        knowledgeService.editKnowledge(knowledge);
        return "list.xhtml?faces-redirect=true";
    }
    public long getId() { return this.id; }
    public void setId(long id) { this.id = id; }
    public KnowledgeEntity getKnowledge() { return this.knowledge; }
    public void setKnowledge(KnowledgeEntity knowledge) { this.knowledge = knowledge; }
}