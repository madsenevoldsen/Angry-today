package com.jayway.angrytoday.resources;

import com.jayway.forest.constraint.Doc;
import com.jayway.forest.roles.Resource;

public class RootResource implements Resource {

    @Doc("Congrats! You are now ready to Rock like it was 1999...")
    public String message() {
        return "See you on December 16th!";
    }

}
