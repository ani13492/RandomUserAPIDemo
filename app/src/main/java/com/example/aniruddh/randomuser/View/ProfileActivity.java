package com.example.aniruddh.randomuser.View;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.aniruddh.randomuser.R;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    @BindView(R.id.profile_photo) CircleImageView photo;
    @BindView(R.id.profile_name) TextView name;
    @BindView(R.id.profile_address) TextView address;
    @BindView(R.id.profile_cell) TextView cell;
    @BindView(R.id.profile_email) TextView email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String profile_name = getIntent().getStringExtra("name");
        String profile_photo = getIntent().getStringExtra(("photo"));
        String profile_dob = getIntent().getStringExtra("cell");
        String profile_address = getIntent().getStringExtra("address");
        String profile_email = getIntent().getStringExtra(("email"));

        name.setText("Name  : "+profile_name);
        setTitle(profile_name);
        Picasso.with(this).load(profile_photo).into(photo);

        cell.setText("Cell : "+profile_dob);
        address.setText("Address : "+profile_address);
        email.setText("Email : "+profile_email);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
