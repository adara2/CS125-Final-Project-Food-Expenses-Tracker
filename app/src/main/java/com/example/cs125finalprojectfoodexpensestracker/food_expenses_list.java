package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class food_expenses_list extends AppCompatActivity {

    private static ArrayList<String> foodNames = new ArrayList<>();
    private static ArrayList<String> foodDescriptions = new ArrayList<>();
    private static ArrayList<Integer> foodPrices = new ArrayList<>();
    private static int arrayPosition = -1;

    static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_expenses_list);

        listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                arrayPosition++;
                openFoodPriceAndDescription();
            }

        });

    }


    public static void addNewExpense(String addFoodName, String addFoodDesc, int addFoodPrice) {
        foodNames.add(addFoodName);
        foodDescriptions.add(addFoodDesc);
        foodPrices.add(addFoodPrice);
    }

    public static int getArrayPosition() {
        return arrayPosition;
    }

    public static int getFoodPrice(int position) {
        return foodPrices.get(position);
    }
    public static String getFoodDescription(int position) {
        return foodDescriptions.get(position);
    }



    public void openFoodPriceAndDescription() {
        Intent intent = new Intent(this, FoodPriceAndDescription.class);
        startActivity(intent);
    }




}
