package com.example.deepank.zoo_directory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class each_animal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        Integer[] zooid ={
                R.drawable.elephant, R.drawable.peacock, R.drawable.lion, R.drawable.zebra, R.drawable.tiger, R.drawable.rhino
        };

        String elephantInfo = "Elephants are large mammals of the family Elephantidae and the order Proboscidea. Two species are traditionally recognised, the African elephant (Loxodonta africana) and the Asian elephant (Elephas maximus), although some evidence suggests that African bush elephants and African forest elephants are separate species. Elephants are scattered throughout sub-Saharan Africa, South Asia, and Southeast Asia. All elephants have several distinctive features the most notable of which is a long trunk or proboscis, used for many purposes, particularly breathing, lifting water and grasping objects. Their incisors grow into tusks, which can serve as weapons and as tools for moving objects and digging. Elephants' large ear flaps help to control their body temperature.";
        String peacockInfo = "Peafowl is a species of birds that include two Asiatic species (the blue or Indian peafowl originally of India and Sri Lanka and the green peafowl of Myanmar, Indochina, and Java) and one African species (the Congo peafowl native only to the Congo Basin) of bird in the genera Pavo and Afropavo of the Phasianidae family, the pheasants and their allies, known for the male's piercing call and, among the Asiatic species, his extravagant eye-spotted tail covert feathers which he displays as part of a courtship ritual. The term peacock is properly reserved for the male; the female is known as a peahen, and the immature offspring are sometimes called peachicks.";
        String lionInfo = "The lion (Panthera leo) is one of the five big cats in the genus Panthera and a member of the family Felidae. The commonly used term African lion collectively denotes the several subspecies found in Africa. With some males exceeding 250 kg (550 lb) in weight, it is the second-largest living cat after the tiger. Wild lions currently exist in sub-Saharan Africa and in Asia (where an endangered remnant population resides in Gir Forest National Park in India) while other types of lions have disappeared from North Africa and Southwest Asia in historic times. Until the late Pleistocene, about 10,000 years ago, the lion was the most widespread large land mammal after humans. They were found in most of Africa, across Eurasia from western Europe to India, and in the Americas from the Yukon to Peru.";
        String zebraInfo = "Zebras are several species of African equids (horse family) united by their distinctive black and white striped coats. Their stripes come in different patterns, unique to each individual. They are generally social animals that live in small harems to large herds. Unlike their closest relatives the horses and donkeys, zebras have never been truly domesticated.There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra. The plains zebra and the mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra is the sole species of subgenus Dolichohippus. The latter resembles an ass, to which it is closely related, while the former two are more horse-like. All three belong to the genus Equus, along with other living equids.";
        String tigerInfo = "The tiger (Panthera tigris) is the largest cat species, reaching a total body length of up to 3.38 m (11.1 ft) over curves and exceptionally weighing up to 388.7 kg (857 lb) in the wild. Its most recognisable feature is a pattern of dark vertical stripes on reddish-orange fur with a lighter underside. The species is classified in the genus Panthera with the lion, leopard, jaguar and snow leopard. Tigers are apex predators, primarily preying on ungulates such as deer and bovids. They are territorial and generally solitary but social animals, often requiring large contiguous areas of habitat that support their prey requirements. This, coupled with the fact that they are indigenous to some of the more densely populated places on Earth, has caused significant conflicts with humans.";
        String rhinoInfo = "Rhinoceros, often abbreviated to rhino, is a group of five extant species of odd-toed ungulates in the family Rhinocerotidae. Two of these species are native to Africa and three to Southern Asia.Members of the rhinoceros family are characterized by their large size (they are some of the largest remaining megafauna, with all of the species able to reach one tonne or more in weight); as well as by an herbivorous diet; a thick protective skin, 1.5–5 cm thick, formed from layers of collagen positioned in a lattice structure; relatively small brains for mammals this size (400–600 g); and a large horn. They generally eat leafy material, although their ability to ferment food in their hindgut allows them to subsist on more fibrous plant matter, if necessary.";

    String info[] = {elephantInfo,peacockInfo,lionInfo,zebraInfo,tigerInfo,rhinoInfo};

        Bundle sentData = getIntent().getExtras();
        if(sentData==null){
            return;
        }
        String receivedData = sentData.getString("animalName");
        TextView s = (TextView)findViewById(R.id.textView2);
        s.setText(receivedData);

        int recievedImageData=sentData.getInt("imgPosition");
        ImageView individualimage=(ImageView) findViewById(R.id.imageView);
        individualimage.setImageResource(zooid[recievedImageData]);

        TextView animaldescription=(TextView)findViewById(R.id.textView3);
        animaldescription.setText(info[recievedImageData]);

        setTitle(receivedData);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings selected", Toast.LENGTH_SHORT).show();
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
