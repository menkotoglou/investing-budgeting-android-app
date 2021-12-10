package com.example.exercisemenelaoskotoglou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BudgetActivity extends AppCompatActivity {

    public static final String NAME = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        TextView tips = findViewById(R.id.tvTips);

        tips.setText("1.Decide why you're budgeting.\n" +
                "2. Always invest 10% percent of your monthly salary.\n" +
                "3. Do not put too much risk on your investments.\n" +
                "4. Keep an emergency fund that you'll be able to live with for at least 6 months of your life.\n" +
                "5. Be generous with others.");


    }

    public void goToSurprise(View v) {

        EditText name = findViewById(R.id.etName);
        String name1 = name.getText().toString();
        Intent in = new Intent(this, MainActivity.class);
        in.putExtra(NAME, name1);
        startActivity(in);
    }
}