package com.jayway.angrytoday.domain;

import java.util.*;

public class AngryPost {

    private String id;
    private String message;
    private List<String> comments;
    private Set<String> tags;

    private static int count=0;

    public AngryPost( String message ) {
        this.id = "baabsdfjeiuro23409aposjdavcxzv"+ count++;
        this.message = message;
        comments = new ArrayList<String>();
        tags = new LinkedHashSet<String>();
    }

    public AngryPost addComment( String comment ) {
        comments.add( comment );
        return this;
    }

    public AngryPost addTag( String tag ) {
        tags.add( tag );
        return this;
    }

    public AngryPost unTag( String tag ) {
        tags.remove( tag );
        return this;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getComments() {
        return Collections.unmodifiableList( comments );
    }

    public Set<String> getTags() {
        return Collections.unmodifiableSet( tags );
    }
}
