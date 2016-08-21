package net.thanatosx.widgets.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.thanatosx.charts.PieChartView;
import net.thanatosx.widgets.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by thanatos on 16/7/25.
 */
public class ChartsFragment extends Fragment{

    @Bind(R.id.view_pie_chart) PieChartView mViewPieChart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (ab != null){
            ab.setSubtitle("charts");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charts, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPieChart.addData(0.02f, 0XFF123456, "2%");
        mViewPieChart.addData(0.1f, 0XFFFF0000, "10%");
        mViewPieChart.addData(0.3f, 0XFF00FF00, "30%");
        mViewPieChart.addData(0.08f, 0XFF0000FF, "8%");
        mViewPieChart.addData(0.1f, 0XFF4527A0, "10%");
        mViewPieChart.addData(0.2f, 0XFF1565C0, "20%");
        mViewPieChart.addData(0.15f, 0XFF00838F, "15%");
        mViewPieChart.addData(0.05f, 0XFF2E7D32, "5%");
    }
}
