package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class food_expenses_list extends AppCompatActivity {

    private static ArrayList<String> foodNames;
    private static ArrayList<String> foodDescriptions;
    private static ArrayList<Integer> foodPrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_expenses_list);




    }

    public static void addNewExpense(String addFoodName, String addFoodDesc, int addFoodPrice) {
        foodNames.add(addFoodName);
        foodDescriptions.add(addFoodDesc);
        foodPrices.add(addFoodPrice);
    }




}
