package com.example.exercisemenelaoskotoglou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class InvestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest);

        Intent dem = new Intent(this, MyService.class);
        startService(dem);
    }

    public void calculateEarnings(View v) {

        EditText money = findViewById(R.id.etMoney);
        CheckBox cb1 = findViewById(R.id.cbStocks);
        CheckBox cb2 = findViewById(R.id.cbBonds);
        CheckBox cb3 = findViewById(R.id.cbRealEstate);
        CheckBox cb4 = findViewById(R.id.cbCrypto);
        SeekBar bar = findViewById(R.id.skBar);

        String s_money = money.getText().toString();
        Integer final_money = Integer.parseInt(s_money);

        int percentage = 0;

        if (cb1.isChecked()) {
            percentage += 10;
        }

        if (cb2.isChecked()) {
            percentage -= 2;
        }

        if (cb3.isChecked()) {
            percentage += 7;
        }

        if (cb4.isChecked()) {
            percentage += 20;
        }

        int comp_years = bar.getProgress();

        Bundle bundle = new Bundle();
        bundle.putInt("percentage", percentage);
        bundle.putInt("years", comp_years);
        bundle.putInt("money", final_money);

        NotificationChannel channel = null;

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(
                    "1",
                    "channel1",
                    NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

            String notifText = "You are going to invest " + s_money + "€ for" + comp_years + " years!";

            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "1")
                    .setSmallIcon(android.R.drawable.btn_plus)
                    .setContentTitle("Money to invest")
                    .setContentText(notifText)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notifyAdmin = NotificationManagerCompat.from(this);
            notifyAdmin.notify(1, notification.build());
        }

        Intent in = new Intent(this, CompoundInterestActivity.class);
        in.putExtras(bundle);
        startActivity(in);
    }
}