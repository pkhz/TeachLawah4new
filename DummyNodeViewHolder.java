package com.example.idea_pad.teachlawah4;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Idea-Pad on 22/4/2018.
 */

public class DummyNodeViewHolder extends RecyclerView.ViewHolder {
    View mView;
    TextView textView_name;
    TextView textView_feedback;

    public DummyNodeViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        textView_name = (TextView) itemView.findViewById(R.id.names);
        textView_feedback = (TextView) itemView.findViewById(R.id.feedbks);

    }

    public void setName (String name) {
        textView_name.setText(name + "");
    }

    public void setFeedback(String fback) {
        textView_feedback.setText(fback);
    }
}
