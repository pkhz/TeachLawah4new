package com.example.idea_pad.teachlawah4;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Booking extends Fragment {


    public Booking() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //if login
            //book
        //else
            // sign in to book

        //Intent intent = new Intent(this, LoginActivity.class);
        //intent.putExtra(User.USER_SKILL_POINTS, user.skillPoints);
        //startActivity(intent);

        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

}
