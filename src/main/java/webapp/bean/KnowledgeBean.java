package webapp.bean;

import webapp.model.KnowledgeEntity;
import webapp.service.KnowledgeService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
@Named
@ViewScoped
public class KnowledgeBean implements Serializable {
    @EJB
    private KnowledgeService knowledgeService;
    private KnowledgeEntity knowledge;
    private long id;

    public List<KnowledgeEntity> getKnowledgeList() { return knowledgeService.findAll(); }

    public String goEditKnowledge(long editId){ return "edit.xhtml?id=" + editId + "&faces-redirect=true"; }

    public void deleteKnowledge(long id){
        knowledge = knowledgeService.findById(id);
        knowledgeService.remove(knowledge);
        return;
    }

    public long getId(){ return this.id; }
    public void setId(long id){ this.id = id; }
    public KnowledgeEntity getKnowledge(){ return this.knowledge; }
    public void setKnowledge(KnowledgeEntity knowledge){ this.knowledge = knowledge; }
}