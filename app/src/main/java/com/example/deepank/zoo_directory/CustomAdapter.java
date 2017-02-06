package com.example.deepank.zoo_directory;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


 public class CustomAdapter extends ArrayAdapter<String > {
     String[] animals;
     Integer zooid[];
     public CustomAdapter(Context context, String[] animals,Integer zooid[]) {
        super(context, R.layout.custom_row ,animals );
         this.animals=animals;
         this.zooid=zooid;

    }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
         LayoutInflater ZooInflater = LayoutInflater.from(getContext());
         View customView = ZooInflater.inflate(R.layout.custom_row, parent, false);

        //String singleanimalitem = getItem(position);
         TextView ZooTextView = (TextView) customView.findViewById(R.id.ZooTextView);
         ImageView ZooImageView = (ImageView) customView.findViewById(R.id.ZooImageView);

         ZooTextView.setText(animals[position]);
         ZooImageView.setImageResource(zooid[position]);
        // ZooImageView.setImageResource(zooid);

         return customView;

     }
 }
