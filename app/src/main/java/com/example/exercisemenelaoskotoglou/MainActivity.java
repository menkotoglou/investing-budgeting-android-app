package com.example.exercisemenelaoskotoglou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in = getIntent();
        String name = in.getStringExtra(BudgetActivity.NAME);

        TextView tv = findViewById(R.id.etSurprise);

        tv.setText("Be careful, " + name + "!\n" +
                "Crypto can get you to the moon, but they can always ground you back to earth" +
                "\nDisclaimer this app is not offering investment advice, just tries to educate people about finance and budgeting!");
    }
}