package com.w3soft.chatapp.w3chat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StatusActivity extends AppCompatActivity {

    private EditText etstatus;
    private Button status_btn;
    private Toolbar mToolbar;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        etstatus = findViewById(R.id.status_new);
        status_btn = findViewById(R.id.status_btn);
        mToolbar = findViewById(R.id.status_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Change Status");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        String user_id = mAuth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("user").child(user_id);

        String old_status = getIntent().getExtras().get("user_status_old").toString();
        etstatus.setText(old_status);

        status_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_status = etstatus.getText().toString();
                ChangeProfileStatus(new_status);
            }
        });

    }

    private void ChangeProfileStatus(String new_status) {
        if (TextUtils.isEmpty(new_status)) {
            Toast.makeText(StatusActivity.this, "Please enter your Status", Toast.LENGTH_SHORT).show();
        } else {

            progressDialog.setTitle("Change Profile Status");
            progressDialog.setMessage("Please wait, while your status being updated");
            progressDialog.show();
            databaseReference.child("user_status").setValue(new_status)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                Intent statusIntent = new Intent(StatusActivity.this, AccountSettingsActivity.class);
                                startActivity(statusIntent);

                                Toast.makeText(StatusActivity.this, "Profile Status updated..", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(StatusActivity.this, "Error Occured..", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
