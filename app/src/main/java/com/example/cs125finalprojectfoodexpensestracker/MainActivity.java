package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class   MainActivity extends AppCompatActivity {

    private Button customizeBudget;
    private Button food;
    private Button addNewExpense;
    private Button viewExpenses;
    private Button submitNewExpense;
    private Button cancelNewExpense;

    private TextView currentDailyBudget;
    private TextView currentWeeklyBudget;
    private TextView currentMonthlyBudget;
    private TextView currentYearlyBudget;
    private TextView foodName;
    private TextView foodDesc;
    private TextView foodPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentDailyBudget = findViewById(R.id.currentDailyBudget);
        currentWeeklyBudget = findViewById(R.id.currentWeeklyBudget);
        currentMonthlyBudget = findViewById(R.id.currentMonthlyBudget);
        currentYearlyBudget = findViewById(R.id.currentYearlyBudget);
        foodName = findViewById(R.id.nameChunk);
        foodDesc = findViewById(R.id.foodDesc);
        foodPrice = findViewById(R.id.foodPrice);

        foodName.setVisibility(View.GONE);
        foodDesc.setVisibility(View.GONE);
        foodPrice.setVisibility(View.GONE);


        currentDailyBudget.setText("Remaining Daily Budget: $" + budget_customization.getDailyBudget());
        currentWeeklyBudget.setText("Remaining Weekly Budget: $" + budget_customization.getWeeklyBudget());
        currentMonthlyBudget.setText("Remaining Monthly Budget: $" + budget_customization.getMonthlyBudget());
        currentYearlyBudget.setText("Remaining Yearly Budget: $" + budget_customization.getYearlyBudget());


        customizeBudget = findViewById(R.id.customizeBudget);
        customizeBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBudgetCustomization();
            }
        });

        food = findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRestaurant();
            }
        });

        submitNewExpense = findViewById(R.id.submitExpense);
        submitNewExpense.setVisibility(View.GONE);
        submitNewExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewExpenses.setVisibility(View.VISIBLE);
                customizeBudget.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                viewExpenses.setVisibility(View.VISIBLE);
                addNewExpense.setVisibility(View.VISIBLE);
                currentDailyBudget.setVisibility(View.VISIBLE);
                currentWeeklyBudget.setVisibility(View.VISIBLE);
                currentMonthlyBudget.setVisibility(View.VISIBLE);
                currentYearlyBudget.setVisibility(View.VISIBLE);
                submitNewExpense.setVisibility(View.GONE);
                cancelNewExpense.setVisibility(View.GONE);
                foodName.setVisibility(View.GONE);
                foodDesc.setVisibility(View.GONE);
                foodPrice.setVisibility(View.GONE);

                String name = foodName.getText().toString();
                String desc = foodDesc.getText().toString();
                int price = Integer.parseInt(foodPrice.getText().toString());

                Log.d("name", name);
                Log.d("desc", desc);
                Log.d("price", foodPrice.getText().toString());

                food_expenses_list.addNewExpense(name, desc, price);

            }
        });

        cancelNewExpense = findViewById(R.id.cancelExpense);
        cancelNewExpense.setVisibility(View.GONE);
        cancelNewExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewExpenses.setVisibility(View.VISIBLE);
                customizeBudget.setVisibility(View.VISIBLE);
                food.setVisibility(View.VISIBLE);
                viewExpenses.setVisibility(View.VISIBLE);
                addNewExpense.setVisibility(View.VISIBLE);
                currentDailyBudget.setVisibility(View.VISIBLE);
                currentWeeklyBudget.setVisibility(View.VISIBLE);
                currentMonthlyBudget.setVisibility(View.VISIBLE);
                currentYearlyBudget.setVisibility(View.VISIBLE);
                submitNewExpense.setVisibility(View.GONE);
                cancelNewExpense.setVisibility(View.GONE);
                foodName.setVisibility(View.GONE);
                foodDesc.setVisibility(View.GONE);
                foodPrice.setVisibility(View.GONE);
            }
        });

        addNewExpense = findViewById(R.id.newExpense);
        addNewExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewExpenses.setVisibility(View.GONE);
                customizeBudget.setVisibility(View.GONE);
                food.setVisibility(View.GONE);
                viewExpenses.setVisibility(View.GONE);
                addNewExpense.setVisibility(View.GONE);
                currentDailyBudget.setVisibility(View.GONE);
                currentWeeklyBudget.setVisibility(View.GONE);
                currentMonthlyBudget.setVisibility(View.GONE);
                currentYearlyBudget.setVisibility(View.GONE);
                submitNewExpense.setVisibility(View.VISIBLE);
                cancelNewExpense.setVisibility(View.VISIBLE);
                foodName.setVisibility(View.VISIBLE);
                foodDesc.setVisibility(View.VISIBLE);
                foodPrice.setVisibility(View.VISIBLE);
            }
        });

        viewExpenses = findViewById(R.id.expensesList);
        viewExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExpensesList();
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

    public void openExpensesList() {
        Intent intent = new Intent(this, food_expenses_list.class);
        startActivity(intent);
    }


}
