package com.example.deepank.zoo_directory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    public String[] animals = {"Elephant", "Peacock", "Lion", "Zebra", "Tiger","Rhinoceros"};
    Integer[] zooid ={
            R.drawable.elephant, R.drawable.peacock, R.drawable.lion, R.drawable.zebra, R.drawable.tiger, R.drawable.rhino
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Converting Array to ListView

        CustomAdapter ZooAdapter = new CustomAdapter(this, animals,zooid);
        ListView ZooListView = (ListView) findViewById(R.id.ZooListView);
        ZooListView.setAdapter(ZooAdapter);
        final String animalsList[] = this.animals;

        //Toasting ListVeiw Elements
        ZooListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String animal = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, animals, Toast.LENGTH_SHORT).show();
                        final Intent animalNameIntent = new Intent(getApplicationContext(), each_animal.class);
                        animalNameIntent.putExtra("animalName", animal);
                        animalNameIntent.putExtra("imgPosition", position);

                        if(position==animalsList.length-1) {

                            AlertDialog.Builder adb = new AlertDialog.Builder(
                                    MainActivity.this);
                            adb.setTitle("Warning: This animal will scare you!!");
                            adb.setMessage("Do you really want to proceed?");

                            adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    startActivity(animalNameIntent);




                                }
                            });
                            adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    Toast.makeText(getApplicationContext(), "Thank God!", Toast.LENGTH_SHORT).show();

                                }
                            });


                            adb.show();
                        }
                        //end Dialog
                        else {
//                            String animal = String.valueOf(parent.getItemAtPosition(position));
                            //Toast.makeText(MainActivity.this, animal, Toast.LENGTH_SHORT).show();

                                                        startActivity(animalNameIntent);
                        }

                    }

                    //Strat
                    //stop




                }
        );


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Settings selected",Toast.LENGTH_SHORT ).show();
            return true;
        }

        if (id == R.id.action_ZooInfo) {
            //Toast.makeText(getApplicationContext(),"Zoo Info",Toast.LENGTH_SHORT ).show();
            Intent i=new Intent(this,zoo_info.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_Uninstall) {
            Uri packageURI = Uri.parse("package:com.example.deepank.zoo_directory");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);

            //Toast.makeText(getApplicationContext(),"Uninstall",Toast.LENGTH_SHORT ).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
