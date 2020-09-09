package webapp.rest.service;

import webapp.model.KnowledgeEntity;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestKnowledge {
    private Integer id;
    @NotNull
    public String title;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public RestKnowledge() {}
    public RestKnowledge(KnowledgeEntity knowledgeEntity) {
        id = knowledgeEntity.getId();
        title = knowledgeEntity.getTitle();
    }
}