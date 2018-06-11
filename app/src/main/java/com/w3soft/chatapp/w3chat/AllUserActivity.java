package com.w3soft.chatapp.w3chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class AllUserActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView recyclerView;
//    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);

        mToolbar = findViewById(R.id.all_user_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("All Users");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("user");
//        Query query = databaseReference.orderByKey();
//
//        FirebaseRecyclerOptions options =
//                new FirebaseRecyclerOptions.Builder<AllUsers>().setQuery(query, AllUsers.class).build();
//
//        FirebaseRecyclerAdapter<AllUsers, AllUserViewHolder> adapter =
//                new FirebaseRecyclerAdapter<AllUsers, AllUserViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull AllUserViewHolder holder, int position, @NonNull AllUsers model) {
//                holder.setUser_name(model.getUser_name());
//                holder.setUser_status(model.getUser_status());
//                holder.setUser_image(model.getUser_image());
//
//            }
//
//            @NonNull
//            @Override
//            public AllUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.all_user_row, parent, false);
//                return new AllUserViewHolder(view);
//            }
//        };
//
//        recyclerView.setAdapter(adapter);
//    }
//
//    public static class AllUserViewHolder extends RecyclerView.ViewHolder{
//
//        View mView;
//
//        public AllUserViewHolder(View itemView) {
//            super(itemView);
//            mView = itemView;
//        }
//
//        public void setUser_name(String user_name){
//            TextView name = (TextView)mView.findViewById(R.id.all_user_name);
//            name.setText(user_name);
//        }
//        public void setUser_status(String user_status){
//            TextView status = (TextView)mView.findViewById(R.id.all_user_status);
//            status.setText(user_status);
//        }
//        public void setUser_image(String user_image){
//            CircleImageView image = (CircleImageView) mView.findViewById(R.id.all_user_image);
//            Picasso.get().load(user_image).into(image);
//        }
//    }
}
