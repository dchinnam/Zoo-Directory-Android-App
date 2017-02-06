package com.example.deepank.zoo_directory;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class zoo_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View view){

        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CALL_PHONE);

        Toast.makeText(getApplicationContext(), "Calling Please Wait", Toast.LENGTH_SHORT).show();

        String number = "8888888";
        Intent callintent = new Intent(Intent.ACTION_CALL);
        callintent.setData(Uri.parse("tel:" + number));
         startActivity(callintent);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Settings selected",Toast.LENGTH_SHORT ).show();
            return true;
        }

        if (id == R.id.action_ZooInfo) {
            Toast.makeText(getApplicationContext(),"Zoo Info",Toast.LENGTH_SHORT ).show();
            Intent i=new Intent(this,zoo_info.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_Uninstall) {
            Uri packageURI = Uri.parse("package:com.example.deepank.zoodirectory");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);

            Toast.makeText(getApplicationContext(),"Uninstall",Toast.LENGTH_SHORT ).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
