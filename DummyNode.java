package com.example.idea_pad.teachlawah4;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DummyNode extends Fragment {

    private static final String TAG = DummyNode.class.getSimpleName();
    //private TextView txtDetails; //later
    private EditText inputName, inputFeed;
    private Button btnSave;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private RecyclerView recyclerView;

    private String userId;

    public DummyNode() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Displaying toolbar icon
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //txtDetails = (TextView) findViewById(R.id.txt_user);
        View v = inflater.inflate(R.layout.activity_fbacks, container, false);

        inputName = (EditText) v.findViewById(R.id.name);
        inputFeed = (EditText) v.findViewById(R.id.feedbac);
        btnSave = (Button) v.findViewById(R.id.btn_save);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'dummy' node
        mFirebaseDatabase = mFirebaseInstance.getReference("dummy");

        // store app title to 'app_title' node
        //mFirebaseInstance.getReference("app_title").setValue("TeachLawah");

        // app_title change listener
        /* mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "App title updated");

                String appTitle = dataSnapshot.getValue(String.class);

                // update toolbar title
                //getSupportActionBar().setTitle(appTitle);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        }); */

        // Save / update the feedback
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String feed = inputFeed.getText().toString();

                createDummyNode(name, feed);

                //later - toast for submitted

                // Check for already existed userId
                /* if (TextUtils.isEmpty(userId)) {
                    createUser(name, email);
                } else {
                    updateUser(name, email);
                }*/
            }
        });

        //query
        Query query = mFirebaseDatabase.orderByKey();

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<DummyNodeData>().setQuery(query, DummyNodeData.class).build();

        FirebaseRecyclerAdapter<DummyNodeData,DummyNodeViewHolder> recyclerAdapter=new FirebaseRecyclerAdapter<DummyNodeData,DummyNodeViewHolder>(options) {
            //DummyNodeData.class,
            //R.layout.individual_row,
            //DummyNodeViewHolder.class,
            //mFirebaseDatabase.child(userId)
            @Override
            protected void onBindViewHolder(DummyNodeViewHolder viewHolder, int position, DummyNodeData model) {
                viewHolder.setName(model.getName());
                viewHolder.setFeedback(model.getOtherdata());
        } /*{
            //syntax changed? check on bind view
            @Override
            protected void onBindViewHolder(DummyNodeViewHolder viewHolder, int position, DummyNodeData model) {
                viewHolder.setName(model.getName());
                viewHolder.setFeedback(model.getOtherdata());

            }*/
            public DummyNodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.individual_row, parent, false);

                return new DummyNodeViewHolder(view);
            }
        };
        recyclerView.setAdapter(recyclerAdapter);


    //toggleButton();

        // Inflate the layout for this fragment
        return v;
    }

    // Changing button text
    /* private void toggleButton() {
        if (TextUtils.isEmpty(userId)) {
            btnSave.setText("Save");
        } else {
            btnSave.setText("Update");
        }
    } */

    /**
     * Creating new feedback node under 'feedback'
     */
    private void createDummyNode(String name, String feedback) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

        if (TextUtils.isEmpty(userId)) {
            //userId = mFirebaseDatabase.push().getKey();
            userId = currentFirebaseUser.getUid();
        }

        FeedbackData feedb = new FeedbackData(name, feedback);

        mFirebaseDatabase.child(userId).setValue(feedb);

        //addUserChangeListener();
    }



    /**
     * User data change listener
     */ /*
    private void addUserChangeListener() {
        // User data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FeedbackData fbd = dataSnapshot.getValue(FeedbackData.class);

                // Check for null
                if (fbd == null) {
                    Log.e(TAG, "Feedback data is null!");
                    return;
                }

                Log.e(TAG, "Feedback is saved!" + fbd.name + ", " + fbd.feedbacks);

                // Display newly updated name and email
                txtDetails.setText(user.name + ", " + user.email);

                // clear edit text
                inputEmail.setText("");
                inputName.setText("");

                toggleButton();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }

    private void updateUser(String name, String feedbacks) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(name))
            mFirebaseDatabase.child(userId).child("name").setValue(name);

        if (!TextUtils.isEmpty(email))
            mFirebaseDatabase.child(userId).child("email").setValue(email);
    }  */

}
