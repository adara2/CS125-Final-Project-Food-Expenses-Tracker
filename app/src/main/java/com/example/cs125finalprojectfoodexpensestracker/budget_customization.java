package com.example.cs125finalprojectfoodexpensestracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    private int budget;
    private int dailyBudget;
    private int weeklyBudget;
    private int monthlyBudget;
    private int yearlyBudget;

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






    }



    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView enterBudget = findViewById(R.id.enterBudget);
        enterBudget.setVisibility(View.VISIBLE);

        EditText enteredBudget = findViewById(R.id.enterBudget);



        if (enteredBudget.getText().toString().isEmpty()) {
            return;
        }

        budget = Integer.parseInt(enteredBudget.getText().toString());



        Spinner timeframe = findViewById(R.id.timeframeSpinner);


        if (timeframe.getItemAtPosition(i).equals(timeframe.getItemAtPosition(0))) {

            dailyBudget = budget;
            weeklyBudget = budget * 7;
            monthlyBudget = budget * 30;
            yearlyBudget = budget * 365;

        }
        if (timeframe.getItemAtPosition(i).equals(timeframe.getItemAtPosition(1))) {


            dailyBudget = budget / 7;
            weeklyBudget = budget;
            monthlyBudget = budget * 4;
            yearlyBudget = budget * 52;

        }
        if (timeframe.getItemAtPosition(i).equals(timeframe.getItemAtPosition(2))) {



            dailyBudget = budget / 30;
            weeklyBudget = budget / 4;
            monthlyBudget = budget;
            yearlyBudget = budget * 12;

        }
        if (timeframe.getItemAtPosition(i).equals(timeframe.getItemAtPosition(3))) {

            dailyBudget = budget / 365;
            weeklyBudget = budget / 52;
            monthlyBudget = budget / 12;
            yearlyBudget = budget;

        }




    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
