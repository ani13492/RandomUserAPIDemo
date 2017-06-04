package com.example.aniruddh.randomuser.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aniruddh.randomuser.Model.User;
import com.example.aniruddh.randomuser.R;
import com.example.aniruddh.randomuser.View.ProfileActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Aniruddh on 6/2/17.
 */


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> mUsers;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mName;
        CircleImageView mAvatar;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.rv_name);
            mAvatar = (CircleImageView) itemView.findViewById(R.id.rv_avatar);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            User user = mUsers.get(getAdapterPosition());
            StringBuilder fullName = new StringBuilder();
            fullName.append(user.getName().getTitle())
                    .append(" ")
                    .append(user.getName().getFirst())
                    .append(" ")
                    .append(user.getName().getLast());

            StringBuilder address = new StringBuilder();
            address.append(user.getLocation().getStreet())
                    .append(", ")
                    .append(user.getLocation().getCity())
                    .append(", ")
                    .append(user.getLocation().getState());

            Context context = view.getContext();
            Intent profileActivity = new Intent(context,ProfileActivity.class);
            profileActivity.putExtra("name",fullName.toString());
            profileActivity.putExtra("photo",user.getPicture().getLarge());
            profileActivity.putExtra("cell",user.getCell());
            profileActivity.putExtra("address",address.toString());
            profileActivity.putExtra("email",user.getEmail());
            context.startActivity(profileActivity);
        }
    }

    public UserAdapter(List<User> user) {
        mUsers = user;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.user_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {

        User user = mUsers.get(position);
        TextView textView = holder.mName;
        StringBuilder userName= new StringBuilder();

        userName.append(user.getName().getFirst())
                .append(" ")
                .append(user.getName().getLast());
        textView.setText(userName);
        CircleImageView imageView = holder.mAvatar;
        Picasso.with(holder.mAvatar.getContext()).load(user.getPicture().getThumbnail()).into(imageView);


    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void add(List<User> list) {

        if (mUsers == null) {
            mUsers = list;
        } else {
            mUsers.addAll(list);
        }
        notifyDataSetChanged();
    }




}
