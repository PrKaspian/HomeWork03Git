package com.example.lesson03;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ContactViewHolder> {
    private Context context;
    private int resource;
    private List<User> data;

    public UserAdapter(Context context, int resource, List<User> users) {
        this.context = context;
        this.resource = resource;
        this.data = users;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View container = inflater.inflate(resource, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(container);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        User user = data.get(position);
        holder.tvFirstName.setText(user.getFirstName());
        holder.tvLastName.setText(user.getLastName());
        holder.ivLogo.setImageResource(user.getAvatar());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName;
        TextView tvLastName;
        ImageView ivLogo;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            ivLogo = itemView.findViewById(R.id.ivLogo);
            itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, FullInfoActivity.class);
            User selectedUser = data.get(getAdapterPosition());
            intent.putExtra(CustomAdapterActivity.KEY_USER, selectedUser);
            context.startActivity(intent);
            });
        }
    }
}
