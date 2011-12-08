package com.jayway.angrytoday.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class AngryPostDTO {

    private String id;
    private String message;
    private List<String> comments;
    private Integer vote;
    private Set<String> tags;
    private Date created;

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments( List<String> comments ) {
        this.comments = comments;
    }

    public Integer getVote() {
        return vote;
    }
    
    public void setVote( Integer vote) {
        this.vote = vote;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
