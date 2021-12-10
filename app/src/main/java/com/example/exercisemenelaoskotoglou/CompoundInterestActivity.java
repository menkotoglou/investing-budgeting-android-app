package com.example.exercisemenelaoskotoglou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class CompoundInterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_interest);

        Intent in = getIntent();
        Bundle b = new Bundle();
        b = in.getExtras();
        int percentage = b.getInt("percentage");
        boolean compound_interest = b.getBoolean("compound_interest");
        int comp_years = b.getInt("years");
        int money = b.getInt("money");

        double d_percentage = percentage;
        double d_comp_years = comp_years;

        GraphView graphView = findViewById(R.id.idGraphView);

        DataPoint[] dp = new DataPoint[comp_years + 1];

        for (int i = 1; i <= comp_years; i++) {
            dp[i] = new DataPoint(i, Math.round(money * (Math.pow((1 + d_percentage / 100), d_comp_years))));
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        for (int i = 1; i <= comp_years; i++) {
            series.appendData(new DataPoint(i, Math.round(money * (Math.pow((1 + d_percentage / 100), d_comp_years)))), true, comp_years + 1);
        }

        graphView.setTitle("Future Earnings");

        graphView.setTitleTextSize(50);

        graphView.addSeries(series);
    }
}