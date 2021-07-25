package com.example.liste_person;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter {

    Activity mActivity;
    Friends myFriends;

    public PersonAdapter(Activity mActivity, Friends myFriends) {
        this.mActivity = mActivity;
        this.myFriends = myFriends;
    }

    @Override
    public int getCount() {
        return myFriends.getFriendsList().size();
    }

    @Override
    public Person getItem(int position) {
        return myFriends.getFriendsList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.activity_person,parent,false);

        TextView tv_names = onePersonLine.findViewById(R.id.tv_name);
        TextView tv_ages = onePersonLine.findViewById(R.id.tv_age);
        ImageView iv_Icon = onePersonLine.findViewById(R.id.Icon_one);

        Person p = this.getItem(position);


        tv_names.setText(p.getNom());
        tv_ages.setText(Integer.toString(p.getAge()));

        int icon_resource_numbers [] ={
                R.drawable.icon01_10,
                R.drawable.icon01_11,
                R.drawable.icon01_12,
                R.drawable.icon01_13
        };
        iv_Icon.setImageResource(icon_resource_numbers[position]);

        return onePersonLine;
    }
}
