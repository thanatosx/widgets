package net.thanatosx.widgets;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import net.thanatosx.widgets.fragment.ChartsFragment;
import net.thanatosx.widgets.fragment.LoadingFragment;
import net.thanatosx.widgets.fragment.PreviewFragment;
import net.thanatosx.widgets.fragment.SolarFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mLayoutTab;
    private ViewPager mViewPager;

    @Override
    @SuppressWarnings("all")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.fragment_preview);

        initWidgets();
        initData();



       /* PieChartView mPieChartView = (PieChartView) findViewById(R.id.view_pie_chart);
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

        mSolarSystem.addPlanets(planet1);*/

    }

    private void initWidgets(){
        mLayoutTab = (TabLayout) findViewById(R.id.layout_tab);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    private void initData(){
        final ArrayList<PagerItem> items = new ArrayList<>();
        items.add(new PagerItem("Charts", ChartsFragment.class));
        items.add(new PagerItem("Preview", PreviewFragment.class));
        items.add(new PagerItem("Preview", PreviewFragment.class));
        items.add(new PagerItem("Preview", PreviewFragment.class));
        items.add(new PagerItem("Preview", PreviewFragment.class));
        items.add(new PagerItem("Preview", PreviewFragment.class));
        items.add(new PagerItem("Loading", LoadingFragment.class));
        items.add(new PagerItem("SolarSystem", SolarFragment.class));

        /*mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Log.d("thanatosx", "---------get item--------");
                return Fragment.instantiate(MainActivity.this, items.get(position).clazz.getName());
            }

            @Override
            public int getCount() {
                return items.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return items.get(position).title;
            }


        });*/

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return false;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return super.instantiateItem(container, position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }
        });

        mLayoutTab.setupWithViewPager(mViewPager);
    }

    private static class PagerItem {
        public String title;
        public Class<? extends Fragment> clazz;

        public PagerItem(String title, Class<? extends Fragment> clazz){
            this.title = title;
            this.clazz = clazz;
        }


    }
}
