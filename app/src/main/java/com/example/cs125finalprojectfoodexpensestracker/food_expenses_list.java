package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class food_expenses_list extends AppCompatActivity {

    private static ArrayList<String> foodNames = new ArrayList<>();
    private static ArrayList<String> foodDescriptions = new ArrayList<>();
    private static ArrayList<Integer> foodPrices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_expenses_list);

        setUpUI();
    }

    public static void addNewExpense(String addFoodName, String addFoodDesc, int addFoodPrice) {
        foodNames.add(addFoodName);
        foodDescriptions.add(addFoodDesc);
        foodPrices.add(addFoodPrice);
    }

    public void setUpUI() {
        ConstraintLayout expensesList = findViewById(R.id.expensesList);
        expensesList.removeAllViews();

        if (foodNames.size() > 0) {
            for (int i = foodNames.size(); i <= 0; i++) {
                View expensesChunk = getLayoutInflater().inflate(R.layout.expenses_chunk, expensesList, false);

                TextView nameChunk = expensesChunk.findViewById(R.id.nameChunk);
                TextView descChunk = expensesChunk.findViewById(R.id.descChunk);
                TextView priceChunk = expensesChunk.findViewById(R.id.priceChunk);

                nameChunk.setText(foodNames.get(i));
                descChunk.setText(foodDescriptions.get(i));
                priceChunk.setText(foodPrices.get(i));

                expensesList.addView(expensesChunk);
            }
        }
    }
}
