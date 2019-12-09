package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class FoodPriceAndDescription extends AppCompatActivity {


    private TextView foodPrice;
    private TextView foodDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("dd", String.valueOf(food_expenses_list.getTest()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_price_and_description);

        foodPrice = findViewById(R.id.foodPrice);
        foodPrice.setText("Food Price: $" + String.valueOf(food_expenses_list.getFoodPrice(food_expenses_list.getTest())));
        foodDescription = findViewById(R.id.foodDescription);
        foodDescription.setText("Food Description: $" + food_expenses_list.getFoodDescription(food_expenses_list.getTest()));

    }
}
