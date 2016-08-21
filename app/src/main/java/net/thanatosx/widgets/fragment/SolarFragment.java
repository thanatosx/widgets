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
        SolarSystemView mSolarSystem = (SolarSystemView) view.findViewById(R.id.view_solar);

        SolarSystemView.Planet planet1 = new SolarSystemView.Planet();
        planet1.setAngleRate(0.01f);
        planet1.setClockwise(false);
        planet1.setRadius(50);

        SolarSystemView.Planet planet2 = new SolarSystemView.Planet();
        planet2.setAngleRate(0.02f);
        planet1.setClockwise(true);
        planet2.setRadius(100);

        SolarSystemView.Planet planet3 = new SolarSystemView.Planet();
        planet3.setAngleRate(0.015f);
        planet1.setClockwise(true);
        planet3.setRadius(200);

        SolarSystemView.Planet planet4 = new SolarSystemView.Planet();
        planet4.setAngleRate(0.007f);
        planet1.setClockwise(false);
        planet4.setRadius(350);

        mSolarSystem.addPlanets(planet1);
        mSolarSystem.addPlanets(planet2);
        mSolarSystem.addPlanets(planet3);
        mSolarSystem.addPlanets(planet4);
        mSolarSystem.setPivotPoint(100f, 100f);
    }
}
