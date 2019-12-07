package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class   MainActivity extends AppCompatActivity {

    private Button customizeBudget;
    private Button food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        customizeBudget = (Button) findViewById(R.id.customizeBudget);

        food = (Button) findViewById(R.id.food);




        customizeBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBudgetCustomization();
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRestaurant();
            }
        });


    }

    public void openBudgetCustomization() {
        Intent intent = new Intent(this, budget_customization.class);
        startActivity(intent);

    }

    public void openRestaurant() {
        Intent intent = new Intent(this, restaurant.class);
        startActivity(intent);
    }


}
