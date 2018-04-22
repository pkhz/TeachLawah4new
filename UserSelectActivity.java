package com.example.idea_pad.teachlawah4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        Button lecturer=(Button)findViewById(R.id.lects);
        lecturer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent lectureract = new Intent(getApplicationContext(), LecturerActivity.class);
                startActivity(lectureract);
            }
        });

        Button students=(Button)findViewById(R.id.studs);
        students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent studentact = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(studentact);
            }
        });
    }
}
