package com.example.user.mambuzicoffeeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView quantity;
    Button numOfCups;
    TextView price;
    int cups = 0;
    private Spinner spinner254, spinner124;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = (TextView) findViewById(R.id.quantity_text_view);
        numOfCups = (Button) findViewById(R.id.number_0f_cups);
        price = (TextView) findViewById(R.id.price);
        addItemsOnSpinner124();
        addListenerOnSpinnerItemSelection();
    }
    public void addItemsOnSpinner124() {

        spinner124 = (Spinner) findViewById(R.id.spinner124);
        List<String> list = new ArrayList<String>();
        list.add("normal coffee");
        list.add("dark coffee");
        list.add("sugarless coffee");
        list.add("coffee with milk");
        list.add("coffee without milk");
        list.add("imported coffee");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner124.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner254 = (Spinner) findViewById(R.id.spinner254);
        spinner124 = (Spinner) findViewById(R.id.spinner124);
        spinner254.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    @SuppressLint("SetTextI18n")
    public void addCups(View view) {
        cups = cups + 1;
        String strCups = String.valueOf(cups);
        quantity.setText(strCups + "cups Ordered");
        setPrice(view);
    }

    private void setPrice(View view) {
        int priceInt = 20 * cups;
        String strPrice = String.valueOf(priceInt);
        price.setText("The cost is shs" + strPrice);
    }
    public void reduceCups(View view) {
        if (cups > 0)

        {
            cups = cups - 1;
            String strCups = String.valueOf(cups);
            quantity.setText(strCups+"cups Ordered");
            setPrice(view);
        }
        else{
            Toast.makeText(this,"you must order at least 1 cup",Toast.LENGTH_SHORT).show();
        }
    }
    public void feedback(View view)
    {
        Toast.makeText(this,"thank you customer", Toast.LENGTH_SHORT).show();
        openMessage(view);
    }
    public void openMessage(View view)
    {
        Intent intent=new Intent(this, Message.class);
        startActivity(intent);
    }
}

