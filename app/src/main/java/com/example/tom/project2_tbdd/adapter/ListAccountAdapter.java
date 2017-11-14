package com.example.tom.project2_tbdd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.project2_tbdd.R;
import com.example.tom.project2_tbdd.model.User;


import java.util.List;

/**
 * Created by tom on 11/12/2017.
 */

public class ListAccountAdapter extends BaseAdapter
{
    Context context;
    int layout;
    List<User> userlist;

    public ListAccountAdapter(Context context, int layout, List<User> userlist){
        this.context =context;
        this.layout = layout;
        this.userlist =userlist;

    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,viewGroup,false);

        ImageView hinh = view.findViewById(R.id.image);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtDetail = view.findViewById(R.id.txtDetail);

        if (userlist.get(i).getGenre() == 1){
            hinh.setImageResource(R.drawable.boy);

        }
        if (userlist.get(i).getGenre() == 2){
            hinh.setImageResource(R.drawable.girl);

        }
        if(userlist.get(i).getGenre() == 0){
            hinh.setImageResource(R.drawable.gay);

        }
        else{
            hinh.setImageResource(R.drawable.ninja);
        }
        txtDetail.setText("Press to more information.");

        txtName.setText(userlist.get(i).getUsername());

        return view;
    }
}
