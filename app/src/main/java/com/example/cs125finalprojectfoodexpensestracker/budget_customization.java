package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class budget_customization extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Button budgetCustomizationHome;
    private static int budget;
    private static int dailyBudget;
    private static int weeklyBudget;
    private static int monthlyBudget;
    private static int yearlyBudget;
    private String timeframeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_customization);


        budgetCustomizationHome = (Button) findViewById(R.id.budgetCustomizationHome);

        budgetCustomizationHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });



        Spinner timeframe = findViewById(R.id.timeframeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.timeframe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeframe.setAdapter(adapter);
        timeframe.setOnItemSelectedListener(this);

        TextView enterBudget = findViewById(R.id.enterBudget);
        enterBudget.setVisibility(View.GONE);


        Button save = findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                EditText enteredBudget = findViewById(R.id.enterBudget);
                budget = Integer.parseInt(enteredBudget.getText().toString());

                if (timeframeSelected.equals("Day")) {

                    dailyBudget = budget;
                    weeklyBudget = budget * 7;
                    monthlyBudget = budget * 30;
                    yearlyBudget = budget * 365;

                    String a = Integer.toString(monthlyBudget);

                    Log.d("dd", a);

                }
                if (timeframeSelected.equals("Week")) {

                    dailyBudget = budget / 7;
                    weeklyBudget = budget;
                    monthlyBudget = budget * 4;
                    yearlyBudget = budget * 52;

                }
                if (timeframeSelected.equals("Month")) {

                    dailyBudget = budget / 30;
                    weeklyBudget = budget / 4;
                    monthlyBudget = budget;
                    yearlyBudget = budget * 12;

                }
                if (timeframeSelected.equals("Year")) {

                    dailyBudget = budget / 365;
                    weeklyBudget = budget / 52;
                    monthlyBudget = budget / 12;
                    yearlyBudget = budget;

                }
            }
        });




    }


    public static int getBudget() {
        return budget;
    }
    public static int getDailyBudget() {
        return dailyBudget;
    }
    public static int getWeeklyBudget() {
        return weeklyBudget;
    }
    public static int getMonthlyBudget() {
        return monthlyBudget;
    }
    public static int getYearlyBudget() {
        return yearlyBudget;
    }



    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView enterBudget = findViewById(R.id.enterBudget);
        enterBudget.setVisibility(View.VISIBLE);




        Spinner timeframe = findViewById(R.id.timeframeSpinner);


        if (timeframe.getItemAtPosition(i).equals(timeframe.getItemAtPosition(0))) {
            timeframeSelected = "Day";
        }
        if (timeframe.getItemAtPosition(i).equals(timeframe.getItemAtPosition(1))) {
            timeframeSelected = "Week";
        }
        if (timeframe.getItemAtPosition(i).equals(timeframe.getItemAtPosition(2))) {
            timeframeSelected = "Month";        }
        if (timeframe.getItemAtPosition(i).equals(timeframe.getItemAtPosition(3))) {
            timeframeSelected = "Year";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }
}
