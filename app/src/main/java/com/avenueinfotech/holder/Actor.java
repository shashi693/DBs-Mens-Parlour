package com.sukenkar.db.holder;

/**
 * Created by suken on 02-12-2016.
 */

public class Actor {

    private String member_name;

    public Actor(){
        super();
    }


    public Actor(String member_name) {
        this.member_name = member_name;

    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }


}
