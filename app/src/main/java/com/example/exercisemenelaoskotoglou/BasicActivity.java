package com.example.exercisemenelaoskotoglou;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.exercisemenelaoskotoglou.databinding.ActivityBasicBinding;

public class BasicActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBasicBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBasicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Budget: See the best budgeting tips.\nTax: Calculate your annual tax.\nInvest: Calculate your future returns.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_budget)
        {
            Intent in = new Intent(this, BudgetActivity.class);
            startActivity(in);
        } else if (id == R.id.action_tax) {
            Intent in = new Intent(this, TaxActivity.class);
            startActivity(in);
        } else if (id == R.id.action_invest) {
            Intent in = new Intent(this, InvestActivity.class);
            startActivity(in);
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToBudget(View view) {
        Intent in = new Intent(this, BudgetActivity.class);
        startActivity(in);
    }

    public void goToInvest(View view) {
        Intent in = new Intent(this, InvestActivity.class);
        startActivity(in);
    }

    public void goToTax(View view) {
        Intent in = new Intent(this, TaxActivity.class);
        startActivity(in);
    }
}