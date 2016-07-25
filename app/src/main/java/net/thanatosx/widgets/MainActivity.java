package net.thanatosx.widgets;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

import net.thanatosx.widgets.ui.PieChartView;
import net.thanatosx.widgets.ui.SolarSystemView;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChartView mPieChartView = (PieChartView) findViewById(R.id.view_pie_chart);
        SolarSystemView mSolarSystem = (SolarSystemView) findViewById(R.id.view_solar_system);

        mPieChartView.addData(0.02f, 0XFF123456, "2%");
        mPieChartView.addData(0.1f, 0XFFFF0000, "10%");
        mPieChartView.addData(0.3f, 0XFF00FF00, "30%");
        mPieChartView.addData(0.08f, 0XFF0000FF, "8%");
        mPieChartView.addData(0.1f, 0XFF4527A0, "10%");
        mPieChartView.addData(0.2f, 0XFF1565C0, "20%");
        mPieChartView.addData(0.15f, 0XFF00838F, "15%");
        mPieChartView.addData(0.05f, 0XFF2E7D32, "5%");

        SolarSystemView.Planet planet1 = new SolarSystemView.Planet();
        planet1.setColor(0XFFFFFFFF);
        planet1.setAngleRate(0.01f);
        planet1.setClockwise(true);
        planet1.setOriginAngle(0);
        planet1.setRadius(200);
        planet1.setSelfRadius(8);
        planet1.setClockwise(false);
        planet1.setTrackWidth(3);
        planet1.setTrackColor(0XFFFFFFFF);

        mSolarSystem.addPlanets(planet1);

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                // do something
            }
        };

        Message message = handler.obtainMessage();
        handler.sendMessage(message);

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                // do something
            }
        });

        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                return false;
            }
        });
    }



}
