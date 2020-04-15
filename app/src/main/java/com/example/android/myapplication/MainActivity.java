package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {


    ListView listViewFruits;
    Button btnDeleteItems;
    Button btnAddFruit;
    EditText editText;
    String[] fruitNames;
    String[] fruitDescription;
    CheckBox cb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fruitNames =  getResources().getStringArray(R.array.fruit_name);
        fruitDescription = getResources().getStringArray(R.array.fruit_description);
        listViewFruits = (ListView)findViewById(R.id.list_view_fruits);
        cb1 = (CheckBox) findViewById(R.id.checkBox);


        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for (int i=0;i<fruitNames.length;i++)
        {
            HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("name",fruitNames[i]);
            hashMap.put("description",fruitDescription[i]+"");
            arrayList.add(hashMap);//add the hashmap into arrayList
        }
        String[] from={"name","description"};//string array
        int[] to={R.id.line_a,R.id.line_b};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.twolines,from,to);//Create object and set the parameters for simpleAdapter
        listViewFruits.setAdapter(simpleAdapter);//sets the adapter for listView



        listViewFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // TODO Auto-generated method stub
                String value= fruitDescription[position];
                Toast toast = Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT);
                toast.show();
                toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);

            }
        });

    }

}





