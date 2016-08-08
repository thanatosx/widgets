package net.thanatosx.widgets.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
        planet1.setRadius(200);

        SolarSystemView.Planet planet2 = new SolarSystemView.Planet();
        planet2.setAngleRate(0.01f);
        planet2.setRadius(400);

        SolarSystemView.Planet planet3 = new SolarSystemView.Planet();
        planet3.setAngleRate(0.01f);
        planet3.setRadius(600);

        SolarSystemView.Planet planet4 = new SolarSystemView.Planet();
        planet4.setAngleRate(0.01f);
        planet4.setRadius(800);

        mSolarSystem.addPlanets(planet1);
        mSolarSystem.addPlanets(planet2);
        mSolarSystem.addPlanets(planet3);
        mSolarSystem.addPlanets(planet4);
    }
}
