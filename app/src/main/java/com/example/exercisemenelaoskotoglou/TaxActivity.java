package com.example.exercisemenelaoskotoglou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TaxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);
    }

    public void calculateTax(View v) {
        EditText tx1 = findViewById(R.id.etIncome);
        ToggleButton tg = findViewById(R.id.tgButton);
        RadioGroup gr = findViewById(R.id.group);
        EditText tx2 = findViewById(R.id.etChildren);
        TextView tx = findViewById(R.id.txTax);

        String income = tx1.getText().toString();
        Integer gross_income = Integer.parseInt(income);
        Integer final_income = Integer.parseInt(income);

        int tax_rate = 0;

        if (tg.isChecked()) {
            tax_rate = 24;
        } else {
            tax_rate = 19;
        }

        int selection = gr.getCheckedRadioButtonId();
        if (selection == R.id.rbYes && tg.isChecked()) {
            tax_rate -= 5;
        } else if (selection == R.id.rbYes) {
            tax_rate -= 4;
        }

        String children = tx2.getText().toString();
        int final_children = Integer.parseInt(children);

        if (final_children == 1) {
            tax_rate -= 2;
        } else if (final_children == 2) {
            tax_rate -= 3;
        } else if (final_children == 3) {
            tax_rate -= 5;
        } else if (final_children > 3){
            tax_rate -= 6;
        }

        final_income = (final_income * tax_rate) / 100;
        tx.setText("The tax you have to pay for this year is: " + final_income +
                "\nYou net salary is: " + (gross_income - final_income));
    }
}