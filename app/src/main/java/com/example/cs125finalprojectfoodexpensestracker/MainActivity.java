package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import org.w3c.dom.Text;

public class   MainActivity extends AppCompatActivity {

    private Button customizeBudget;
    private Button food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView currentDailyBudget = findViewById(R.id.currentDailyBudget);
        TextView currentWeeklyBudget = findViewById(R.id.currentWeeklyBudget);
        TextView currentMonthlyBudget = findViewById(R.id.currentMonthlyBudget);
        TextView currentYearlyBudget = findViewById(R.id.currentYearlyBudget);

        currentDailyBudget.setText("Remaining Daily Budget: $" + budget_customization.getDailyBudget());
        currentWeeklyBudget.setText("Remaining Weekly Budget: $" + budget_customization.getWeeklyBudget());
        currentMonthlyBudget.setText("Remaining Monthly Budget: $" + budget_customization.getMonthlyBudget());
        currentYearlyBudget.setText("Remaining Yearly Budget: $" + budget_customization.getYearlyBudget());







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
