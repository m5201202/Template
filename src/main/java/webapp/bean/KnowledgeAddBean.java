package webapp.bean;

import webapp.model.KnowledgeEntity;
import webapp.service.KnowledgeService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class KnowledgeAddBean implements Serializable{
    private KnowledgeEntity knowledge;
    @EJB
    private KnowledgeService knowledgeService;
    public void init(){ knowledge = new KnowledgeEntity(); }
    public String create(){
        knowledgeService.addKnowledge(knowledge);
        return "list.xhtml?faces-redirect=true";
    }
    public KnowledgeEntity getKnowledge() { return knowledge; }
    public void setKnowledge(KnowledgeEntity knowledge) { this.knowledge = knowledge; }
}