package com.example.idea_pad.teachlawah4;

/**
 * Created by Idea-Pad on 15/4/2018.
 */

public class FeedbackData {

    public String name;
    public String feedbacks;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public FeedbackData() {
    }

    public FeedbackData(String name, String feedbacks) {
        this.name = name;
        this.feedbacks = feedbacks;
    }
}
