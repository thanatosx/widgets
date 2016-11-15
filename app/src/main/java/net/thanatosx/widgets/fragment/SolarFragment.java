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
import net.thanatosx.widgets.utils.UIKit;

import java.util.Random;

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
                final int px = 100;
                final int py = 100;
                int w = UIKit.getDeviceWidth() - px;
                int h = UIKit.getDeviceHeight() - py;
                double mMaxRadius = Math.pow(w * w + h * h, 1.f / 2.f);
                Random random = new Random(System.currentTimeMillis());
                for (int i = 60, radius = 100 + i; ; i = (int) (i * 1.4), radius += i){
                    SolarSystemView.Planet planet = new SolarSystemView.Planet();
                    planet.setClockwise(random.nextInt(10) % 2 == 0);
                    planet.setAngleRate((random.nextInt(35) + 1) / 1000.f);
                    planet.setRadius(radius);
                    mSolarSystem.addPlanets(planet);
                    if (radius > mMaxRadius) break;
                }
                mSolarSystem.setPivotPoint(100f, 100f);
            }
        });

    }
}
