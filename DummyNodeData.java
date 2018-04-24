package com.example.idea_pad.teachlawah4;

/**
 * Created by Idea-Pad on 18/4/2018.
 */

public class DummyNodeData {


    public String name;
    public String otherdata;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public DummyNodeData() {
    }

    public DummyNodeData(String name, String otherdata) {
        this.name = name;
        this.otherdata = otherdata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherdata() {
        return otherdata;
    }

    public void setOtherdata(String otherdata) {
        this.otherdata = otherdata;
    }
}
