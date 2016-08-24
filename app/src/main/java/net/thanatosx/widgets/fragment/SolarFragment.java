package net.thanatosx.widgets.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.thanatosx.previewer.ImagePreviewView;
import net.thanatosx.solar.SolarSystemView;
import net.thanatosx.widgets.R;

/**
 * Created by thanatos on 16/7/25.
 */
public class SolarFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (ab != null){
            ab.setSubtitle("solar system");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_solar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final SolarSystemView mSolarSystem = (SolarSystemView) view.findViewById(R.id.view_solar);

        mSolarSystem.post(new Runnable() {
            @Override
            public void run() {
                SolarSystemView.Planet planet1 = new SolarSystemView.Planet();
                planet1.setAngleRate(0.01f);
                planet1.setClockwise(false);
                planet1.setRadius(50);

                SolarSystemView.Planet planet2 = new SolarSystemView.Planet();
                planet2.setAngleRate(0.02f);
                planet2.setClockwise(true);
                planet2.setRadius(100);

                SolarSystemView.Planet planet3 = new SolarSystemView.Planet();
                planet3.setAngleRate(0.015f);
                planet3.setClockwise(true);
                planet3.setRadius(200);

                SolarSystemView.Planet planet4 = new SolarSystemView.Planet();
                planet4.setAngleRate(0.017f);
                planet4.setClockwise(false);
                planet4.setRadius(350);

                SolarSystemView.Planet planet5 = new SolarSystemView.Planet();
                planet5.setAngleRate(0.03f);
                planet5.setClockwise(false);
                planet5.setRadius(550);

                SolarSystemView.Planet planet6 = new SolarSystemView.Planet();
                planet6.setAngleRate(0.023f);
                planet6.setClockwise(true);
                planet6.setRadius(800);

                SolarSystemView.Planet planet7 = new SolarSystemView.Planet();
                planet7.setAngleRate(0.013f);
                planet7.setClockwise(false);
                planet7.setRadius(1100);

                mSolarSystem.addPlanets(planet1);
                mSolarSystem.addPlanets(planet2);
                mSolarSystem.addPlanets(planet3);
                mSolarSystem.addPlanets(planet4);
                mSolarSystem.addPlanets(planet5);
                mSolarSystem.addPlanets(planet6);
                mSolarSystem.addPlanets(planet7);
                mSolarSystem.setPivotPoint(100f, 100f);
                mSolarSystem.setRadialGradient(100f, 100f, 1000f, 0XFFFFFFFF, 0XFF0000AA);
                mSolarSystem.repaint();
            }
        });

    }
}
